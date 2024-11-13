import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

public class ClimatizacionClaseB implements controlTemperatura, controlVentilacion, controlCalefaccion, controlAire, controlMantenimiento  {
    private int temperaturaExterior;
    private boolean sistemaEncendido;
    private int temperaturaActual;
    private int nivelVentilacion;
    private String direccionVentilacion;
    private boolean modoEcoActivado;
    private int nivelCalefaccionAsientos;
    private int nivelCalefaccionHabitaculo;
    private boolean calefaccionRapidaActivada;
    private boolean desempaniadorActivado;
    private ArrayList<String> historialMantenimiento;
    private int ContadorMantenimiento;



    public ClimatizacionClaseB() {
        this.temperaturaExterior = 20;
        this.sistemaEncendido = false;
        this.temperaturaActual = 20;
        this.nivelVentilacion = 0;
        this.direccionVentilacion = "parabrisas";
        this.modoEcoActivado = false;
        this.nivelCalefaccionAsientos = 0;
        this.calefaccionRapidaActivada = false;
        this.desempaniadorActivado = false;
        this.historialMantenimiento = new ArrayList<String>();
        this.nivelCalefaccionHabitaculo = 0;

    }

    //Métodos de controlTemperatura
    @Override
    public void encender() {
        this.sistemaEncendido = true;
        this.ContadorMantenimiento += 1;
    }

    @Override
    public void apagar() {
        this.sistemaEncendido = false;
    }

    @Override
    public String ajustarTemperatura(int temperatura) {
        if (temperatura >= 16 && temperatura <= 28) {
            this.temperaturaActual = temperatura;
            return "Temperatura ajustada a " + temperatura + " grados";
        }

        else {
            return "La temperatura debe estar entre 16 y 28 grados";
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
    public void activarModoAutomatico() {
        if(this.temperaturaExterior < 10){
            this.ajustarTemperatura(28);


        }else if(this.temperaturaExterior > 28){
            this.ajustarTemperatura(16);
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
                nivelCalefaccionHabitaculo = 1;
                calefaccionRapidaActivada = false;
            }
        }, 300000);
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
    public void ajustarDireccionVentilacion(String direccion) {
        this.direccionVentilacion = direccion;

    }

    @Override
    public String programarMantenimiento(String fecha) {
        historialMantenimiento.add(fecha);
        return "Mantenimiento programado para la fecha: " + fecha;
    } 



    @Override
    public String avisoDeMantenimiento (String fechaActual) {
        for (String mantenimiento : historialMantenimiento) {
            if (fechaActual.equals(mantenimiento)) {
                return "Hay un mantenimiento programado hoy: " + fechaActual;
            }
        }

        if (ContadorMantenimiento >= 30) {
            return "Es necesario programar un mantenimiento por el uso excesivo del sistema de climatización";
        }    
        return "No hay mantenimientos programados para hoy";
    }


    @Override
    public void ajustarDistribucionAire(String distribucion) {
        System.out.println("PENDIENTE");
    } 

    @Override
    public boolean getSistemaEncendido() {
        return this.sistemaEncendido;
    }
}