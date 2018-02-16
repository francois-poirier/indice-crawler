package org.poc.indice;

import java.io.Serializable;

public class IndiceEntry implements Serializable{
  
    /**
     * 
     */
    private static final long serialVersionUID = -824211909227722994L;
    private String country;
    private String indice;    
    private String last;
    private String var;
    private String eve;
    private String varJanuaryFirst;
    
    public IndiceEntry(String country, String indice, String last, String var, String eve, String varJanuaryFirst) {
        super();
        this.country = country;
        this.indice = indice;
        this.last = last;
        this.var = var;
        this.eve = eve;
        this.varJanuaryFirst = varJanuaryFirst;
    }

    public String getCountry() {
        return country;
    }

    public String getIndice() {
        return indice;
    }

    public String getLast() {
        return last;
    }

    public String getVar() {
        return var;
    }

    public String getEve() {
        return eve;
    }

    public String getVarJanuaryFirst() {
        return varJanuaryFirst;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((eve == null) ? 0 : eve.hashCode());
        result = prime * result + ((indice == null) ? 0 : indice.hashCode());
        result = prime * result + ((last == null) ? 0 : last.hashCode());
        result = prime * result + ((var == null) ? 0 : var.hashCode());
        result = prime * result + ((varJanuaryFirst == null) ? 0 : varJanuaryFirst.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IndiceEntry other = (IndiceEntry) obj;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (eve == null) {
            if (other.eve != null)
                return false;
        } else if (!eve.equals(other.eve))
            return false;
        if (indice == null) {
            if (other.indice != null)
                return false;
        } else if (!indice.equals(other.indice))
            return false;
        if (last == null) {
            if (other.last != null)
                return false;
        } else if (!last.equals(other.last))
            return false;
        if (var == null) {
            if (other.var != null)
                return false;
        } else if (!var.equals(other.var))
            return false;
        if (varJanuaryFirst == null) {
            if (other.varJanuaryFirst != null)
                return false;
        } else if (!varJanuaryFirst.equals(other.varJanuaryFirst))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IndiceEntry [country=" + country + ", indice=" + indice + ", last=" + last + ", var=" + var + ", eve=" + eve + ", varJanuaryFirst=" + varJanuaryFirst + "]";
    }
    
    

}
