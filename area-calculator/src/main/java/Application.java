public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();
        Shape s1 = new Square(2);
        aggregator.addShape(s1);
        Shape s2 = new Square(4);
        aggregator.addShape(s2);
        Shape c1 = new Circle(2);
        aggregator.addShape(c1);
        Shape e1 = new Ellipse(1, 2);
        aggregator.addShape(e1);
        Shape r1 = new Rectangle(5, 2);
        aggregator.addShape(r1);
        Shape t1 = new Triangle(2, 3);
        aggregator.addShape(t1);

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());

    }
}
