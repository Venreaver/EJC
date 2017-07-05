package add_03;

public class CollisionCat {
    private String name = "Jack";

    public CollisionCat(String catName) {
        this.name = catName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollisionCat lostCat = (CollisionCat) o;

        return name != null ? name.equals(lostCat.name) : lostCat.name == null;
    }

    @Override
    public int hashCode() {
        return 5;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CollisionCat{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
