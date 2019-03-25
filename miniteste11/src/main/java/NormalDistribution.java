public class NormalDistribution extends ProbabilityDistribution{

    private final String name;
    private double mean;
    private double stddev;

    NormalDistribution(){
        this(0.0, 1.0);
    }

    NormalDistribution(double mean, double stddev){
        this("", mean, stddev);
        if(stddev == 0)
            throw new IllegalArgumentException();

        this.mean = mean;
        this.stddev = stddev;
    }

    NormalDistribution(String name, double mean, double stddev){
        this.name = name;
        addDistribution(this);
    }

    public double getMean() {
        return mean;
    }

    public double getStddev() {
        return stddev;
    }

    @Override
    public double probabilityDensityFunction(double x) {
        return Math.exp(-Math.pow(x-mean, 2)/(2*stddev*stddev))/Math.sqrt(2*Math.PI*stddev*stddev);
    }

    @Override
    public double calcRangeProbability(int a, int b) {
        Function function = new Function() {
            private double stddev;
            private double mean;

            public void setParameters(double stddev, double mean){
                this.stddev = stddev;
                this.mean = mean;
            }

            @Override
            public double evaluate(double x) {
                return Math.exp(-Math.pow(x-mean, 2)/(2*stddev*stddev))/(Math.sqrt(2*Math.PI*stddev*stddev));
            }
        };

        ((Function) function).setParameters(stddev, mean);

        double value = SimpsonMethod.calcIntegral(function, a, b, 0.0005);
        value = (double)Math.round(value*100000)/100000;
        return value;
    }

    @Override
    public double calcLeftProbability(double x) {

        Function function = new Function() {
            private double stddev;
            private double mean;

            public void setParameters(double stddev, double mean){
                this.stddev = stddev;
                this.mean = mean;
            }

            @Override
            public double evaluate(double x) {
                return Math.exp(-Math.pow(x-mean, 2)/(2*stddev*stddev))/(Math.sqrt(2*Math.PI*stddev*stddev));
            }
        };

        ((Function) function).setParameters(stddev, mean);

        double value = SimpsonMethod.calcIntegral(function, -10000, x, 0.0005);
        value = (double)Math.round(value*100000)/100000;
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(null == obj)
            return false;

        if(obj.getClass() != NormalDistribution.class)
            return false;

        NormalDistribution n = (NormalDistribution)obj;

        return this.mean == n.getMean() && this.stddev == n.getStddev();
    }

    @Override
    public String toString() {
        return "N("+this.mean+", "+this.stddev+")";
    }

    public String getName() {
        return name;
    }
}
