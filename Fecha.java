
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
        assert fechaValida(day, month, year) : "La fecha no es valida";
        dia = day;
        mes = month;
        anho = year;
    }

    /**
     * Verifica si la fecha es valida
     */
    public boolean fechaValida(int day, int month, int year)
    {
        if (month > 0 && month <= 12 && postGregoriano(day, month, year) && day > 0 && day <= cantDias(month,year) ){
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
         }  else if(month == 2){
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
    
    /**
     * Indica si es PostGregoriano
     */
    private boolean postGregoriano(int day, int month, int year){
    if(year < 1582){
      return false;
    }
    
    if(year == 1582  && month < 10){
      return false;
    }
    
    if(year == 1582 && month == 10 && day < 15){
      return false;
    }
    
    return true;
    }
    
    public int obtenerDia(){
     return dia;
    }
    
    public int obtenerMes(){
     return mes;
    }
    
    public int obtenerAño(){
     return anho;
    }
     
    public void cambiarDia(int nuevoDia){
     assert fechaValida(nuevoDia, mes, anho): "dia invalido";
     dia = nuevoDia;
    }
    
    public void cambiarMes(int nuevoMes){
     assert fechaValida(dia, nuevoMes, anho): "dia invalido";
     mes = nuevoMes;
    }
    
    public void cambiarAnho(int nuevoAnho){
     assert fechaValida(dia, mes, nuevoAnho): "dia invalido";
     anho = nuevoAnho;
    }
    
    /**
     * Te da la fecha en formato string 
     */
    public String toString(){
        return dia + "/" + mes + "/" + anho;
    }
    
    /**
     * compara si 2 fechas representan el mismo dia mes y año
     */
    public boolean equals(Fecha otraFecha){
        if(dia == otraFecha.obtenerDia() && mes == otraFecha.obtenerMes() && anho == otraFecha.obtenerAño()){
          return true;
        } else {
          return false;
        }
    }
    
    /**
     * compara si 2 fechas representan el mismo dia mes y año
     */
    public boolean esAnterior(Fecha otraFecha){
        if(anho < otraFecha.obtenerAño()){
        return true;
        } else if(anho == otraFecha.obtenerAño() && mes < otraFecha.obtenerMes()){
          return true;
         } else if (anho == otraFecha.obtenerAño() && mes == otraFecha.obtenerMes() && dia < otraFecha.obtenerDia()){
            return true;
         } else {
        return false;
    }
    }
}
            
    


