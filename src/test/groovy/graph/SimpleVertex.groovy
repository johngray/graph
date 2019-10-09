package graph

class SimpleVertex {

    private final int number

    SimpleVertex(int number) {
        this.number = number
    }

    int getNumber() {
        return number
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        SimpleVertex that = (SimpleVertex) o

        if (number != that.number) return false

        return true
    }

    int hashCode() {
        return number
    }

    @Override
    public String toString() {
        return "SimpleVertex{" +
                "number=" + number +
                '}';
    }
}
