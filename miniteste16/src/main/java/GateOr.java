public class GateOr extends LogicGate {
    private LogicVariable output;
    private LogicVariable input[];

    GateOr(LogicVariable output, LogicVariable input1, LogicVariable input2) throws ColisionException {
        this.output = output;
        if(this.output.getCalculatedBy() != null)
            throw new ColisionException();

        this.output.setLogicGate(this);
        this.output.setValue(input1.getValue() || input2.getValue());
        input = new LogicVariable[2];
        this.input[0] = input1;
        this.input[1] = input2;
    }

    @Override
    public LogicVariable getOutput() {
        return output;
    }

    @Override
    public LogicVariable[] getInputs() {
        return input;
    }

    @Override
    public String getSymbol() {
        return "OR";
    }

    @Override
    public String getFormula() {
        return "OR("+this.input[0].getFormula()+","+this.input[1].getFormula()+")";
    }

    @Override
    public void setValue(LogicVariable logicVariable) {
        if(this.input[0].equals(logicVariable) || this.input[1].equals(logicVariable))
            this.output.setValue(this.input[0].getValue() || this.input[1].getValue());
    }
}
