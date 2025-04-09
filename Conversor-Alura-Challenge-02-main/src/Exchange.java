public class Exchange {
    private String base_code;
    private String target_code;
    private float conversion_rate;
    private float base_value;
    private float conversion_value;

    public Exchange(){

    }

    public void obtainValue(float conversion_rate){
        this.conversion_rate = conversion_rate;
        this.conversion_value = base_value* conversion_rate;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public float getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(float conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public float getConversion_value() {
        return conversion_value;
    }

    public void setConversion_value(float conversion_value) {
        this.base_value = conversion_value;
    }

    public float getBase_value() {
        return base_value;
    }

    public void setBase_value(float base_value) {
        this.base_value = base_value;
    }

    @Override
    public String toString() {
        return "Valor Base : | "+base_value+" "+base_code+"$ | -> | Valor de Cambio: "+conversion_value+" "+target_code+"$ | Con tasa de conversion = "+conversion_rate;
    }
}
