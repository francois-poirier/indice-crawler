package org.poc.endpoint;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeVisitor;
import org.poc.indice.IndiceEntry;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.annotation.Transformer;

@MessageEndpoint
public class Scraper {

    private final String ROWLINK_CLASS = "rowLink";
    private final String COUNTRY_CLASS = "tdv-libelle_pays";
    private final String INDICE_CLASS = "tdv-libelle";
    private final String LAST_CLASS = "tdv-last";
    private final String VAR_CLASS = "tdv-var";
    private final String EVE_CLASS = "tdv-prev_close";
    private final String VARJANUARYFIRST_CLASS = "tdv-var_an";

    @Splitter(inputChannel = "channel1", outputChannel = "channel2")
    public List<Element> scrape(ResponseEntity<String> payload) {

        String html = payload.getBody();
        final Document htmlDoc = Jsoup.parse(html);
        final Elements anchorNodes = htmlDoc.select("body").select("tbody").select("tr");

        final List<Element> anchorList = new ArrayList<Element>();
        anchorNodes.traverse(new NodeVisitor() {
            @Override
            public void head(org.jsoup.nodes.Node node, int depth) {
                if (node instanceof org.jsoup.nodes.Element) {
                    Element e = (Element) node;
                    anchorList.add(e);
                }
            }

            @Override
            public void tail(Node node, int depth) {
            }
        });

        return anchorList;

    }

    @Filter(inputChannel = "channel2", outputChannel = "channel3")
    public boolean filter(Element payload) {
        return payload.hasClass(ROWLINK_CLASS);
    }

    @Transformer(inputChannel = "channel3", outputChannel = "channel4")
    public IndiceEntry convert(Element payload) throws ParseException {
        IndiceEntry entry = null;
        String country = payload.getElementsByClass(COUNTRY_CLASS).text();
        String indice = payload.getElementsByClass(INDICE_CLASS).text();
        String last = payload.getElementsByClass(LAST_CLASS).text();
        String var = payload.getElementsByClass(VAR_CLASS).text();
        String eve = payload.getElementsByClass(EVE_CLASS).text();
        String varJanuaryFirst = payload.getElementsByClass(VARJANUARYFIRST_CLASS).text();
        entry = new IndiceEntry(country, indice, last, var, eve, varJanuaryFirst);
        return entry;

    }
}
