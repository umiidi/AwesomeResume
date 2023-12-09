package entity;

public class Country {
    private int id;
    private String name;
    private String nationality;

    public Country() {
    }

    public Country(int id, String name, String countryName) {
        this.id = id;
        this.name = name;
        this.nationality = countryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return nationality;
    }

    public void setCountryName(String countryName) {
        this.nationality = countryName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Country other = (Country) obj;
        return this.id == other.id;
    }
    
    @Override
    public String toString() {
        return name + " " +(nationality);
    }
}
