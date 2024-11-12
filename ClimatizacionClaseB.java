import java.util.Timer;
import java.util.TimerTask;

public class ClimatizacionClaseB implements controlTemperatura, controlVentilacion, controlCalefaccion, controlAire {
    private boolean sistemaEncendido;
    private int temperaturaActual;
    private int nivelVentilacion;
    private String direccionVentilacion;
    private boolean modoEcoActivado;
    private int nivelCalefaccionAsientos;
    private int nivelCalefaccionHabitaculo;
    private boolean calefaccionRapidaActivada;
    private boolean desempaniadorActivado;

    public ClimatizacionClaseB() {
        this.sistemaEncendido = false;
        this.temperaturaActual = 20;
        this.nivelVentilacion = 0;
        this.direccionVentilacion = "parabrisas";
        this.modoEcoActivado = false;
        this.nivelCalefaccionAsientos = 0;
        this.calefaccionRapidaActivada = false;
        this.desempaniadorActivado = false;
    }

    //Métodos de controlTemperatura
    @Override
    public void encender() {
        this.sistemaEncendido = true;
    }

    @Override
    public void apagar() {
        this.sistemaEncendido = false;
    }

    @Override
    public void ajustarTemperatura(int temperatura) {
        if (temperatura >= 16 && temperatura <= 28) {
            this.temperaturaActual = temperatura;
        }
    }

    //Métodos de controlVentilacion
    @Override
    public void ajustarNivelVentilacion(int nivel) {
        if (modoEcoActivado == true) {
            return;
        }

        if (nivel >= 0 && nivel <= 3) {
            this.nivelVentilacion = nivel;
        }
    }

    @Override
    public void activarModoEco() {
        this.modoEcoActivado = true;
        this.nivelVentilacion = 1;
    }

    @Override
    public void desactivarModoEco() {
        this.modoEcoActivado = false;
    }

    //Métodos de controlCalefaccion
    @Override
    public void ajustarCalefaccionAsientos(int nivel) {
        if (nivel >= 0 && nivel <= 3) {
            this.nivelCalefaccionAsientos = nivel;
        }
    }

    @Override
    public void activarCalefaccionRapida() {
        this.calefaccionRapidaActivada = true;
        this.nivelCalefaccionHabitaculo = 3;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                nivelCalefaccionHabitaculo = 1; // Vuelve al nivel normal después de 5 minutos (300000 ms)
                calefaccionRapidaActivada = false;
            }
        }, 300000); // 300000 ms = 5 minutos
    }

    //Métodos de controlAire
    @Override
    public void encenderDesempaniador() {
        this.desempaniadorActivado = true;
    }

    @Override
    public void apagarDesempaniador() {
        this.desempaniadorActivado = false;
    }





    
    //Métodos de Rompich
    @Override
    public void activarModoAutomatico() {
        System.out.println("PENDIENTE");
    }

    @Override
    public void ajustarDireccionVentilacion(String direccion) {
        System.out.println("PENDIENTE");
    }

    @Override
    public void ajustarDistribucionAire(String distribucion) {
        System.out.println("PENDIENTE");
    }
}