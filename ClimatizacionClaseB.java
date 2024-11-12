import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.List;

public class ClimatizacionClaseB implements controlTemperatura, controlVentilacion, controlCalefaccion, controlAire {
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
    private List<String> historialMantenimiento;
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
        if(this.temperaturaExterior < 10){
            this.ajustarTemperatura(28);


        }else if(this.temperaturaExterior > 28){
            this.ajustarTemperatura(16);
        }
    }

    @Override
    public void DireccionVentilacion(String direccion) {
        this.direccionVentilacion = direccion;

    }

    @Override
    public String programarMantenimiento(String fecha) {
        historialMantenimiento.add(fecha);
        return "Mantenimiento programado para la fecha: " + fecha;
    } 


    @Override
    public String avisoDeMantenimiento(String fechaActual) {
        for (String mantenimiento : historialMantenimiento) {
            if (fechaActual.equals(mantenimiento)) {
                return "Hay un mantenimiento programado hoy: " + fechaActual;
            }
        }

        if (ContadorMantenimiento >= 30) {
            return "Es necesario programar un mantenimiento por el uso excesivo del sistema de climatización";
        }
        
        
    }






}