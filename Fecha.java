
/**
 * Write a description of class Fecha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fecha
{
    // instance variables - replace the example below with your own
    private int dia;
    private int mes;
    private int anho;

    /**
     * Constructor for objects of class Fecha
     */
    public Fecha(int day, int month, int year)
    {
        // crea el objeto
        day = dia;
        month = mes;
        year = anho;
    }

    /**
     * Verifica si la fecha es valida
     */
    private boolean fechaValida(int day, int month, int year)
    {
        if (month > 0 && month <= 12 && year >= 1582 && day > 0 && day <= cantDias(month,year) ){
        return true;
      } else {
        return false;
      }
    }
    
    /**
     * Verifica si la fecha es valida
     */
    private boolean esBisiesto(int year)
    {
        assert year >= 1582 : "tiene q ser mayor o = a ese año";
         if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            return true;
         } else {
        return false;
        }
    }
    
    /**
     * devuelve la cantidad de dias que tiene el mes dado
     * en el año indicado (considerando años bisiestos)
     */
    private int cantDias(int month, int year)
    {
        assert month > 0 && month <= 12 : "el mes es entre 1 y 12";
        assert year >= 1582 : "el año es mayor o igual a 1582";
        int cantidad;
         if(month == 1 || month == 3|| month == 5|| month == 7|| month == 8|| month == 10|| month == 12){
            cantidad = 31;
         } else if(month == 2){
             if(esBisiesto(year)){ 
                 cantidad = 29;
            } else {
                 cantidad = 28;
            }      
         } else {
            cantidad = 30;
         }
         
        return cantidad;
    }
}