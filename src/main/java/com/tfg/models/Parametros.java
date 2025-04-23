package com.tfg.models;

public enum Parametros {
    // Hematología
    HEMOGLOBINA("Hemoglobina"),
    HEMATOCRITO("Hematocrito"),
    LEUCOCITOS("Leucocitos"),
    NEUTROFILOS("Neutrófilos"),
    LINFOCITOS("Linfocitos"),
    PLAQUETAS("Plaquetas"),
    
    // Bioquímica
    GLUCOSA("Glucosa"),
    CREATININA("Creatinina"),
    UREA("Urea"),
    ACIDO_URICO("Ácido úrico"),
    BILIRRUBINA_TOTAL("Bilirrubina total"),
    BILIRRUBINA_DIRECTA("Bilirrubina directa"),
    TRANSAMINASAS("Transaminasas"),
    GOT_AST("GOT/AST"),
    GPT_ALT("GPT/ALT"),
    FOSFATASA_ALCALINA("Fosfatasa alcalina"),
    GAMMA_GT("Gamma GT"),
    PROTEINAS_TOTALES("Proteínas totales"),
    ALBUMINA("Albúmina"),
    COLESTEROL_TOTAL("Colesterol total"),
    COLESTEROL_HDL("Colesterol HDL"),
    COLESTEROL_LDL("Colesterol LDL"),
    TRIGLICERIDOS("Triglicéridos"),
    
    // Iones
    SODIO("Sodio"),
    POTASIO("Potasio"),
    CLORO("Cloro"),
    CALCIO("Calcio"),
    FOSFORO("Fósforo"),
    MAGNESIO("Magnesio"),
    
    // Otros
    TSH("TSH"),
    T4_LIBRE("T4 libre"),
    FERRITINA("Ferritina"),
    HIERRO("Hierro"),
    TRANSFERRINA("Transferrina"),
    PCR("Proteína C Reactiva");

    private final String nombre;

    Parametros(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}