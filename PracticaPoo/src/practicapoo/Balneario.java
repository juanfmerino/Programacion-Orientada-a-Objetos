/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Juand
 */
public class Balneario implements Serializable {
    
    private static Balneario instancia;
    private ArrayList<Habitaciones> habitaciones;
    private ArrayList<Facturacion> facturas;
    private ArrayList<ServicioSpa> spas;
    private ArrayList<Cliente> clientes;
    private ArrayList<Reservas> reservas;
    
    
    public Balneario(){
        habitaciones= new ArrayList<Habitaciones>();
        facturas=new ArrayList<Facturacion>();
        spas=new ArrayList<ServicioSpa>();
        clientes= new ArrayList<Cliente>(); 
        reservas=new ArrayList<Reservas>();
    }
    
    
    public static Balneario getIntancia(){
        if(instancia == null){
            instancia = new Balneario(); 
        }
        return instancia; 
    }
    
    
    public void altaHabitacion(Habitaciones habitacion){
        
        boolean flag = true; 
        
        for(int i=0;i<habitaciones.size();i++){
            if(habitaciones.get(i).get_numHabitacion()== habitacion.get_numHabitacion()){
                flag = false; 
            }
        }
        if(flag != false){
            habitaciones.add(habitacion); 
            System.out.println("Habitacion creada");
            System.out.println("La nueva Habitacion tiene los siguientes datos:");
            System.out.println("Numero Habitacion:" +habitacion.get_numHabitacion());
            System.out.println("El precio de la Habitacion es de: "+habitacion.get_precio());
        
        }
        else{
            System.out.println("La Habitacion ya existe. No puede ser introducido");
        }

    
    }
    
    public void eliminarHabitacion(int numHabitacion){
        
        int i;
        for(i=0;i<habitaciones.size();i++){
            if(habitaciones.get(i).get_numHabitacion() == numHabitacion){
                  habitaciones.remove(i);
                  System.out.println("La Habitacion ha sido eliminada");
            }
        } 
    
    }
  
    
    public void mostrarInfoHabitacion(int numero){
            
         int i;
        
        System.out.println();
        System.out.println();
         
        for(i=0;i<habitaciones.size();i++){
            if(habitaciones.get(i).get_numHabitacion() == numero){
                System.out.println("El numero de la Habitacion es:"+habitaciones.get(i).get_numHabitacion());
                System.out.println("El precio de la Habitacion es:"+ habitaciones.get(i).get_precio());
            }
        } 
        
    }

    public ArrayList<Habitaciones> get_array(){
        return habitaciones; 
    }
    
  public void añadirServicio(ServicioSpa spa){
        
        boolean flag = true; 
        
        for(int i=0;i<spas.size();i++){
            if(spas.get(i).Codigo.equals(spa.Codigo)){
                flag = false; 
            }
        }
        if(flag != false){
            spas.add(spa);
            System.out.println("");
            System.out.println("Servico de spa creada");
            System.out.println("");
            System.out.println("El nuevo Servicio de Spa tiene los siguientes datos:");
            System.out.println("Codigo Servico Spa:" +spa.Codigo);
            System.out.println("El precio del Servicio de Spa es de: "+spa.coste);
            System.out.println("La descripcion del Servicio de Spa es de: "+spa.descripcion);    
        }
        else{
            System.out.println("El servicio de spa ya existe. No puede ser introducido");
        }
    
    }
    

   public void eliminarServicoSpa(String codigo){
        
        int i;
   
        for(i=0;i<spas.size();i++){
            if(spas.get(i).Codigo.equals(codigo)){
                  spas.remove(i);
            }
        } 
    
    }
   

    public void obtenerInfoServicio(String codigo){
        
        int i;
        
        System.out.println();
        System.out.println();
        for(i=0;i<spas.size();i++){
            if(spas.get(i).Codigo.equals(codigo)){
                System.out.println("El codigo del spa es:"+spas.get(i).Codigo);
                System.out.println("Cuesta:"+spas.get(i).coste);
                System.out.println("Su descripcion:"+spas.get(i).descripcion);
            }else{
                 System.out.println("El servico de spa no existe");
            }
        } 

    }
   

    public ArrayList<ServicioSpa> get_array_spa(){
        return spas; 
    }
    
    public void AltaCliente(Cliente cliente){
        
     boolean flag = true; 
        
        for(int i=0;i<clientes.size();i++){
            if(clientes.get(i).Dni.equals(cliente.Dni)){
                flag = false; 
            }
        }
        if(flag != false){
            clientes.add(cliente); 
            System.out.println("El cliente creado");
            System.out.println("El nuevo cliente tiene los siguientes datos:");
            System.out.println("Dni del cliente:" +cliente.Dni);
            System.out.println("El nombre del cliente es : "+cliente.nombre+ cliente.apellidos);
            System.out.println("El telefono del clinte es:" +cliente.telefono);
        
        }
        else{
            System.out.println("El cliente ya existe. No puede ser introducido");
        }
    }
    
    public void eliminarCliente(String Dni){
        
        for(int i=0;i<clientes.size();i++){
            if(clientes.get(i).Dni.equals(Dni)){
                clientes.remove(i);
            }
        }
         System.out.println("Cliente eliminado con exito");
        
    }
    
    public boolean validar_dni(String Dni){
        
        char letra=Dni.charAt(8);
        
        if(Dni.length()==9){
            if(Character.isLetter(letra)){
                return true;
            }else{
                System.out.println("ERROR haber una letra");
                return false;
            }
        }else{
            System.out.println("ERROR FORMATO INCORRECTO");
        }
        return false;
    
    }
    
    public void mostrarInfoCliente(String dni){
            
         int i;
        
        System.out.println();
        System.out.println();
         
        for(i=0;i<clientes.size();i++){
            if(clientes.get(i).Dni.equals(dni)){
            System.out.println("El cliente en la posicion numero:"+i);
            System.out.println("Dni del cliente: "+clientes.get(i).Dni);
            System.out.println("Nombre del cliente:"+clientes.get(i).nombre+ clientes.get(i).apellidos);
            System.out.println("Telefono del cliente: "+clientes.get(i).telefono);
            }
        } 
        
    }
    
    public ArrayList<Cliente> getCliente(){
        return clientes; 
    }
    
    public void ListaHabitacion(int tipo){

        int j = 0;
        int num = 0;
        
        if(tipo==2){
            //Comprobrar Habitaciones Individuales
            for(j=0;j<habitaciones.size();j++){
                if(habitaciones.get(j) instanceof Individual){
                        System.out.println("Las Habitaciones Individuales dsiponibles son:"+  habitaciones.get(j).numHabitaciones);
                }
            }
        
        }
        
        if(tipo==3){
            //Comprobar Habitaciones Dobles
            for(j=0;j<habitaciones.size();j++){
                if(habitaciones.get(j) instanceof Doble){

                        if(habitaciones.get(j).baño==true)
                            System.out.println("Las Habitaciones Dobles con baño propio dsiponibles son:"+  habitaciones.get(j).numHabitaciones);
                        System.out.println("Las Habitaciones Dobles sin baño propio disponibles son:"+  habitaciones.get(j).numHabitaciones);
                    
                }
            }
        
        }
        
        
        if(tipo==1){
            //Comprobar Habitaciones Familiares
            for(j=0;j<habitaciones.size();j++){
                if(habitaciones.get(j) instanceof Familiar){
                        System.out.println("Las Habitaciones Familiares disponibles son:"+ habitaciones.get(j).numHabitaciones);
                }
            }

        }

    }
    
    public boolean comprobarHabitacion(int tipo,int numHabitacion){

        int j = 0;
        int num = 0;
        boolean flag = false;
        
        if(tipo==2){
            //Comprobrar Habitaciones Individuales
            for(j=0;j<habitaciones.size();j++){
                if(habitaciones.get(j) instanceof Individual){
                    if(numHabitacion==habitaciones.get(j).numHabitaciones){
                        return true;
                    }     
                }
            }
        
        }
        
        if(tipo==3){
            //Comprobar Habitaciones Dobles
            for(j=0;j<habitaciones.size();j++){
                if(habitaciones.get(j) instanceof Doble){
                    if(numHabitacion==habitaciones.get(j).numHabitaciones){
                        return true;
                    }
                }
            }
        
        }
        
        
        if(tipo==1){
            //Comprobar Habitaciones Familiares
            for(j=0;j<habitaciones.size();j++){
                if(habitaciones.get(j) instanceof Familiar){
                    if(numHabitacion==habitaciones.get(j).numHabitaciones){
                        return true;
                    }
                }
            }

        }
        return false;

    }
    


    public float costeHabitacion(int numHabitacion){
        float precio = 0;
        
        for(int i=0;i<habitaciones.size();i++){
            if(habitaciones.get(i).numHabitaciones==numHabitacion){
            
                precio=habitaciones.get(i).precio;
            }
        
        }
        return precio;
    
    
    }
    
    public float costeServicio(String codigo){
        float precio = 0;
        
        for(int i=0;i<spas.size();i++){
            if(spas.get(i).Codigo.equals(codigo)){
            
                precio=spas.get(i).coste;
            }
        
        }
        return precio;
    
    
    }
    
    
    public boolean hayHabitacione(){
        
        if(habitaciones.size()==0){
            return false;
        }else
            return true;
    }
    
    public void annadirReservaHabitacion(Reservas reservaHab){
        
            reservas.add(reservaHab);
            System.out.println("Reserva creada con exito"); 

    }
    void annadirReservaSpa(Reservas reservaSpa) {
        
        reservas.add(reservaSpa);
        System.out.println("Reserva creada con exito"); 
        
    }
     public void eliminarReserva(int numReserva){
        
        
        int i;
   
        for(i=0;i<reservas.size();i++){
            if(reservas.get(i).numReserva== numReserva){
                   reservas.remove(i);
                   System.out.println("Reserva eliminada con exito");
            }
        } 
        
    
    }
     
    public void eliminarReservaFactura(int numReserva){
        
        reservas.remove(numReserva);
        System.out.println("Reserva eliminada con exito");
    
    }
    
    public void mostrarInfoReserva(int numReserva){
     
         int i;
        
        System.out.println();
        System.out.println();
         
        for(i=0;i<reservas.size();i++){
            if((reservas.get(i).numReserva == numReserva)&&(reservas.get(i) instanceof ReservaHabitacion)){
                System.out.println("Ese numero corresponde a una reserva de Habitacion");
                System.out.println("El Numero de la reserva es: "+reservas.get(i).numReserva);
                System.out.println("El numero de habitacion de la reserva es: "+ reservas.get(i).numHabitacion);
                 System.out.println("El precio de la reserva es: "+reservas.get(i).costeTotal);
                System.out.println("La fecha es: "+ reservas.get(i).diaInicio+"/" +reservas.get(i).diaFin);
            }
            if((reservas.get(i).numReserva == numReserva)&&(reservas.get(i) instanceof ReservaSpa)){
                System.out.println("Ese numero corresponde a una reserva de Spa");
                System.out.println("El Numero de la reserva es: "+reservas.get(i).numReserva);
                System.out.println("La Habitacion que tiene el spa es: "+ reservas.get(i).numHabitacion);
                 System.out.println("El precio de la reserva es: "+reservas.get(i).costeTotal);
                System.out.println("La fecha es: "+ reservas.get(i).diaInicio);
            }
        } 
     
     }
    
    public void menuMostarReservas(){
         

       
       int i;
        System.out.println();
        System.out.println();
        
         System.out.println("Listado de todas las reservas de habitaciones");
         for(i=0;i<reservas.size();i++){
            if(reservas.get(i) instanceof ReservaHabitacion){
               
                System.out.println("El Numero de la reserva es: "+reservas.get(i).numReserva);
                System.out.println("El numero de habitacion de la reserva es: "+ reservas.get(i).numHabitacion);
                 System.out.println("El precio de la reserva es: "+reservas.get(i).costeTotal);
                System.out.println("La fecha es: "+ reservas.get(i).diaInicio+"/" +reservas.get(i).diaFin);
            }
         }
         
         System.out.println("Listado de todas las reservas del Spa");
         for(i=0;i<reservas.size();i++){
            if(reservas.get(i) instanceof ReservaSpa){
               
                System.out.println("El Numero de la reserva es: "+reservas.get(i).numReserva);
                System.out.println("La Habitacion que tiene el spa es: "+ reservas.get(i).numHabitacion);
                 System.out.println("El precio de la reserva es: "+reservas.get(i).costeTotal);
                System.out.println("La fecha es: "+ reservas.get(i).diaInicio);
            }
        }  
   }
    public ArrayList<Reservas> array_reserva(){
        return reservas; 
    }
    
    
    /*public boolean comprobarfechaSpa(int numHabitacion, LocalDate diainicio, LocalDate diafin){
        for(int i=0;i<reservas.size();i++){
            if(numHabitacion==reservas.get(i).numHabitacion){
                
            }
        }
    }*/

    public boolean validarfecha(LocalDate inicio, LocalDate fin){
        if(inicio.compareTo(fin)<=0){
            return true;
        }else{
            System.out.println("La fecha de Fin no puede ser menor que la fecha de Inicio");
        }
        return false;
    }
    public boolean compararfecha(int numHabitacion,LocalDate inicio,LocalDate fin){
        //No funciona como deberia funcionar no compara bien la fecha
        
        for(int i =0;i<reservas.size();i++){
            if(numHabitacion==reservas.get(i).numHabitacion){
                if((inicio.isAfter(reservas.get(i).diaFin))){
                   return true;

                }
            }
        }
           return false;
    }
    
  
    public int clienteHabitacion(String cliente){
        int num;
    
         for(int i =0;i<reservas.size();i++){
             if(reservas.get(i).cliente.equals(cliente)){
                num=reservas.get(i).numHabitacion;
                System.out.println("EL cliente tiene la habitacion " +reservas.get(i).numHabitacion+ " reservada");
               return num;
            }
    
         }
        return 0;

    }
    
    public boolean validarfechaspa(int numHabitacion,LocalDate inicio){
        
        boolean flag = false;
        
         for(int i =0;i<reservas.size();i++){
            if(numHabitacion==reservas.get(i).numHabitacion){
                if(reservas.get(i) instanceof ReservaHabitacion){
                    if((reservas.get(i).diaInicio.isAfter(inicio))&&(reservas.get(i).diaFin.isBefore(inicio))){
                        flag=true;
                        System.out.println("La fechas son:"+reservas.get(i).diaInicio+" / " +reservas.get(i).diaFin);
                    }else
                         System.out.println("La fechas son:"+reservas.get(i).diaInicio+" / " +reservas.get(i).diaFin);
                        flag= false;
                }
            }
        } 
        return flag;
       
    }
    

    public ArrayList<Facturacion> getFacturas() {
        return facturas;
    }
    
    public void MostrarFacturas(){
        for(int i=0;i<facturas.size();i++){
            System.out.println("Codigo   "  +facturas.get(i).Codigo);
            System.out.println("Cliente   "    +facturas.get(i).cliente);
            System.out.println("Coste Total   " +facturas.get(i).costeTotal);
            System.out.println("Fecha  "    +facturas.get(i).fechaFact);
        }
        
    }
    public void MostrarFactura(String Codigo){
        
        for(int i=0;i<facturas.size();i++){
            if(facturas.get(i).Codigo==Codigo){
                System.out.println("Codigo  "  +facturas.get(i).Codigo);
                System.out.println("Cliente  " +facturas.get(i).cliente);
                System.out.println("Coste Total   "   +facturas.get(i).costeTotal);
                System.out.println("Fecha    "     +facturas.get(i).fechaFact);
            }
        }
        
    }
    
    public void AltaFacturas(Facturacion factura){
        
        //int numReserva []=new int[10];
        int i;
        facturas.add(factura);
        System.out.println("La factura se ha añadido a la lista de facturas");
        
    }
    
    
    
    public boolean descuento(int anno,String cliente){
       
        int ano_array;
        boolean descuento = false;
        
        
        for(int i=0;i<facturas.size();i++){
            ano_array=facturas.get(i).fechaFact.getYear();
            if(ano_array==anno){
                if(cliente.equals(facturas.get(i).cliente)){
                    descuento= true;
                }
            }
            
        }
        return descuento;
       
        
        
    }
    
    public boolean fechaFact(LocalDate fecha, int numHab){
        
        for(int i =0;i<reservas.size();i++){
            if(numHab==reservas.get(i).numHabitacion){
                   if((fecha.isAfter(reservas.get(i).diaFin))||(fecha.equals(reservas.get(i).diaFin))){
                        return true;
                   }else{
                        System.out.println("La fecha de la factura debera ser el mismo dia o despues del ultimo dia de la reserva");
                   }
            }
        }
        
        
        return false;
    
    
    }

    public float costeTotal(int reserva,LocalDate fecha){
    float coste = 0;
        for(int i =0;i<reservas.size();i++){
            if(reserva==reservas.get(i).numReserva){
                    coste=coste+reservas.get(i).costeTotal;
                          
            }
        }
    
      return coste;
    }
    
    public boolean existeCliente(String cliente){
        
    boolean alta = false;
    
        for(int i=0;i<clientes.size();i++){
            
            if(cliente.equals(clientes.get(i).Dni)){
                 System.out.println("Cliente esta dado de alta");
                 alta=true;
                 return alta;
            }else{
                System.out.println("Cliente no existe, le tienes que dar de alta");
                alta=false;
                
            }
        }
        
        return alta;
    
    
    }
    
    public Habitaciones CamasSupletorias(Habitaciones h){

        int camas = 0;
        boolean y;

            do{
                try{
                    y=true;
                    System.out.println("Cuanta camas desea?");
                    camas=MyInput.readInt();
                }catch(NumberFormatException e){
                    y=false;
                     System.out.println("Debe Introducir un numero");
                }
            }while(y=false);
            
            h = new CamaSupletoria(h,camas);

        
        
        return h;
    }
    
    public int posicionFacturas(){
       
        int posicion=0;
       for(int i=0;i<facturas.size();i++){
           posicion=facturas.lastIndexOf(i);
           
       }
      
           
           
       return posicion-1;   
            
        
    }
    
    
    
}
    
    
