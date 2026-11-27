import java.util.Random;
public class Neuron {

    private double[] weight;
    private double bias;
    private double lastOutputs;
    private double[] lastInputs;
    
    public Neuron(int input){
        weight = new double[input];
        Random rand = new Random();
        for(int i = 0; i < input; i++){
            weight[i] = rand.nextDouble()*2 -1;
        }
        bias = rand.nextDouble() *2 -1;
    }

    public double activate(double[] input){
        double sum = bias;
        for(int i = 0; i < input.length; i++){
            sum += input[i] * weight[i];
        }
        lastOutputs = sigmoid(sum);
        return lastOutputs;
    }

    public double sigmoid(double sum){
        return 1.0/(1.0 + Math.exp(-sum));
    }

    public double sigmoidDerivative(){
        return lastOutputs * (1.0 - lastOutputs);
    }
    
}
