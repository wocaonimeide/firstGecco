package com.gecco.firstgecco.entities;

import java.io.Serializable;

/**
 * dictionary_entity
 * @author 
 */
public class DictionaryEntity implements Serializable {
    private Integer id;

    private String dictionaryCode;

    private String dictionaryType;

    private String dictionaryName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictionaryCode() {
        return dictionaryCode;
    }

    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode;
    }

    public String getDictionaryType() {
        return dictionaryType;
    }

    public void setDictionaryType(String dictionaryType) {
        this.dictionaryType = dictionaryType;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DictionaryEntity other = (DictionaryEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDictionaryCode() == null ? other.getDictionaryCode() == null : this.getDictionaryCode().equals(other.getDictionaryCode()))
            && (this.getDictionaryType() == null ? other.getDictionaryType() == null : this.getDictionaryType().equals(other.getDictionaryType()))
            && (this.getDictionaryName() == null ? other.getDictionaryName() == null : this.getDictionaryName().equals(other.getDictionaryName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDictionaryCode() == null) ? 0 : getDictionaryCode().hashCode());
        result = prime * result + ((getDictionaryType() == null) ? 0 : getDictionaryType().hashCode());
        result = prime * result + ((getDictionaryName() == null) ? 0 : getDictionaryName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dictionaryCode=").append(dictionaryCode);
        sb.append(", dictionaryType=").append(dictionaryType);
        sb.append(", dictionaryName=").append(dictionaryName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}