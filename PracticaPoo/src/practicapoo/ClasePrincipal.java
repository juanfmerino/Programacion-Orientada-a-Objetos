/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Juand
 */
public class ClasePrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Balneario balneario = deserializar();
        if (balneario==null)
            balneario = Balneario.getIntancia();
        
        if(balneario.hayHabitacione()==true){ //Lo primero que se debera hacer es dar de alta una habitacion
            menuPrincipal(balneario);
        }else{
            System.out.println("No hay habitaciones dadas de alta deberas de dar alta una");
            menuAltaHabitacion(balneario); 
            menuPrincipal(balneario);
        }
        serializar(balneario);
        
        
    }
    
    
    
    public static void menuPrincipal(Balneario balneario){
        int opcion;
        
        do{
            opcion = -1; 
            System.out.println("Menú Principal");
            System.out.println("\n\t1.- Menu Habitaciones ");
            //
            System.out.println("\t2.- Menu Facturas ");
            System.out.println("\t3.- Menu Clientes "); 
            System.out.println("\t4.- Menu ServicoSpa  ");
            System.out.println("\t5.- Guardar copia de los datos del balneario");
            System.out.println("\t6.- Menu Reservas ");
            System.out.println("\t0.- Cerrar el programa");

            System.out.println("Elija una de las opciones: ");
            try{
                opcion = MyInput.readInt();
                
                if(opcion<0 || opcion>6){
                    throw new Excepcion("EL numero debe estar entre 1 y 6");
                }
            }
            catch(Excepcion e){
                System.out.println(e.getMessage());
            }
            catch(NumberFormatException nfe){
                System.out.println("Error. Debe introducir un número, no un caracter");
            }
            
            switch(opcion){
                case 1: menuHabitaciones(balneario); 
                    break; 
                case 2: menuFacturas(balneario); 
                    break; 
                case 3: menuClientes(balneario); 
                    break; 
                case 4: menuServicoSpa(balneario); 
                    break; 
                case 5: serializar(balneario);
                    break; 
                case 6: menuReserva(balneario);
                    break;
                case 0: cerrarPrograma(); 
                    break; 
            }
            
        }while(opcion != 0);
        
    }
    
    private static void serializar(Balneario balneario){
        
        try{
            FileOutputStream out = new FileOutputStream("GestionBalneario.dat");        
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(balneario);
        }
        catch(Exception e){
            System.err.println(e);
        }
        System.out.println("Guardando datos...");
        
    }
    
    private static Balneario deserializar(){
        Balneario balneario = null; 
        try{
            FileInputStream in = new FileInputStream("GestionBalneario.dat");
            ObjectInputStream ois = new ObjectInputStream(in);
            balneario = (Balneario) ois.readObject();          
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Recuperando datos...");

        return balneario; 
    }
    
    
    public static void menuHabitaciones(Balneario balneario){
        
        int opcion;
        

        do{
            opcion = -1; 
            System.out.println("Menú Habitaciones");
            System.out.println("\n\t1.- Añadir Habitacion ");
            System.out.println("\t2.- Eliminar Habitacion ");
            System.out.println("\t3.- Obtener listado de Habitaciones "); 
            System.out.println("\t4.- Obtener Informacion de una Habitaciones ");
            System.out.println("\t0.- Salir del Menu de Habitaciones");

            System.out.println("Elija una de las opciones: ");
            try{
                opcion = MyInput.readInt();
                
                if(opcion<0 || opcion>4){
                    throw new Excepcion("EL numero debe estar entre 1 y 4");
                }
            }
            catch(Excepcion e){
                System.out.println(e.getMessage());
            }
            catch(NumberFormatException nfe){
                System.out.println("Error. Debe introducir un número, no un caracter");
            }
            
            switch(opcion){
                case 1: menuAltaHabitacion(balneario); 
                    break; 
                case 2: menueEliminarHabitacion(balneario);
                    break; 
                case 3: menuObtenerListadoHabitaciones(balneario); 
                    break; 
                case 4: menuMostrarInfoHabitacion(balneario); 
                    break; 
                case 0: System.out.println("Estas volviendo al Menu Principal");
                    break; 
            }
            
        }while(opcion != 0);
        
        
    }
    
    
    public static void menuFacturas(Balneario balneario){
        
        int opcion;
        
        do{
            opcion = -1; 
            System.out.println("Menú de Facturas");
            System.out.println("\n\t1.- Generar Factura ");
            System.out.println("\t2.- Mostrar Facturas ");
            System.out.println("\t3.- Mostrar Datos de la Factura "); 
            System.out.println("\t0.- Salir del Menu de Facturas");

            System.out.println("Elija una de las opciones: ");
            try{
                opcion = MyInput.readInt();
                
                if(opcion<0 || opcion>3){
                    throw new Excepcion("EL numero debe estar entre 1 y 3");
                }
            }
            catch(Excepcion e){
                System.out.println(e.getMessage());
            }
            catch(NumberFormatException nfe){
                System.out.println("Error. Debe introducir un número, no un caracter");
            }
            
            switch(opcion){
                case 1: menuGenerarFacturas(balneario); 
                    break; 
                case 2: menuMostrarListadoFacturas(balneario); 
                    break; 
                case 3: menuMostrarInfoFactura(balneario); 
                    break; 
                case 0: System.out.println("Estas volviendo al Menu Principal");
                    break; 
            }
            
        }while(opcion != 0);
        
        
    }
    
    
    public static void menuClientes(Balneario balneario){
             
        int opcion;
        
        do{
            opcion = -1; 
            System.out.println("Menú de Clientes");
            System.out.println("\n\t1.- Añadir Clientes ");
            System.out.println("\t2.-Eliminar Cliente");
            System.out.println("\t3.- Obtener Listado de Clientes ");
            System.out.println("\t4.- Obtener Informacion de un Cliente "); 
            System.out.println("\t0.- Salir del Menu de Clientes");

            System.out.println("Elija una de las opciones: ");
            try{
                opcion = MyInput.readInt();
                
                if(opcion<0 || opcion>4){
                    throw new Excepcion("EL numero debe estar entre 1 y 4");
                }
            }
            catch(Excepcion e){
                System.out.println(e.getMessage());
            }
            catch(NumberFormatException nfe){
                System.out.println("Error. Debe introducir un número, no un caracter");
            }
            
            switch(opcion){
                case 1: menuAñadirCliente(balneario); 
                    break; 
                    
                case 2: menuEliminarCliente(balneario);
                    break;
                case 3: menuObtenerListadoClientes(balneario); 
                    break; 
                case 4: menuMostrarInfoCliente(balneario); 
                    break;  
               
                case 0: System.out.println("Estas volviendo al Menu Principal");
                    break; 
            }
            
        }while(opcion != 0);
        
    }
    
    
    public static void menuServicoSpa(Balneario balneario){
        
        int opcion;
        
        do{
            opcion = -1; 
            System.out.println("Menú del Servicio de Spa");
            System.out.println("\n\t1.- Añadir Servicio de Spa");
            System.out.println("\t2.- Eliminar Servicio de Spa ");
            System.out.println("\t3.- Obtener lisatdo de los Servicio de Spa "); 
            System.out.println("\t4.- Obtner informacion de un Servicio de Spa "); 
            System.out.println("\t0.- Salir del Menu del Servico de Spa");

            System.out.println("Elija una de las opciones: ");
            try{
                opcion = MyInput.readInt();
                
                if(opcion<0 || opcion>4){
                    throw new Excepcion("EL numero debe estar entre 1 y 4");
                }
            }
            catch(Excepcion e){
                System.out.println(e.getMessage());
            }
            catch(NumberFormatException nfe){
                System.out.println("Error. Debe introducir un número, no un caracter");
            }
            
            switch(opcion){
                case 1: menuAñadirServicioSpa(balneario); 
                    break; 
                case 2: menuElimiarServicioSpa(balneario);
                    break; 
                case 3: menuObtenerListadoServicioSpa(balneario); 
                    break;  
                case 4: menuMostrarInfoServicioSpa(balneario); 
                    break;
                case 0: System.out.println("Estas volviendo al Menu Principal");
                    break; 
            }
            
        }while(opcion != 0);
    }

    
    public static void menuReserva(Balneario balneario){
        
         int opcion;

         
        

        do{
            opcion = -1; 
            System.out.println("Menú Reservas");
            System.out.println("\n\t1.- Añadir Reserva ");
            System.out.println("\t2.- Eliminar Reserva ");
            System.out.println("\t3.- Obtener listado de las Reservas "); 
            System.out.println("\t4.- Obtener Informacion de una Reserva ");
            System.out.println("\t0.- Salir del Menu de Reservas");

            System.out.println("Elija una de las opciones: ");
            try{
                opcion = MyInput.readInt();
                
                if(opcion<0 || opcion>4){
                    throw new Excepcion("EL numero debe estar entre 1 y 4");
                }
            }
            catch(Excepcion e){
                System.out.println(e.getMessage());
            }
            catch(NumberFormatException nfe){
                System.out.println("Error. Debe introducir un número, no un caracter");
            }
            
            switch(opcion){
                case 1: menuAnnadirReserva(balneario); 
                    break; 
                case 2: menuEliminarReserva(balneario);
                    break; 
                case 3: menuMostarReservas(balneario);
                    break; 
                case 4: menuMostarInfoReserva(balneario);
                    break; 
                case 0: System.out.println("Estas volviendo al Menu Principal");
                    break; 
            }
            
        }while(opcion != 0);
    
    }
    
    public static void menuAltaHabitacion(Balneario balneario){
        
        Habitaciones habitacion;
        int numHabitacion = 0,tipo = 0;
        String planta,numero;
        float precio = 0;
        boolean excepcion;
        boolean baño = false;
        char respuesta;
        String clase;

        Scanner teclado = new Scanner(System.in);

        
        System.out.println("Has entrado en el Menu de alta de Habitaciones");
        excepcion=false;

                System.out.println("En que planta se encuentra la habitacion a introducir?");
                planta=MyInput.readString();
                
                System.out.println("Introudce el numero de la Habitacion");
                numero=MyInput.readString();

                String i = String.valueOf(planta) + String.valueOf(numero);//Con esto concatenamos las dos cadenas el primer numero es la planta y los demas el numero de la habitacion
                numHabitacion=Integer.valueOf(i);

                System.out.println("Introduce el precio de la habitacion");
                precio=MyInput.readFloat();
                
                do{
        
                    System.out.println("Tipo de Habitacion");
                    System.out.println("\t\t1.- Familiar");
                    System.out.println("\t\t2.- Individual");
                    System.out.println("\t\t3.- Doble");
                    System.out.println("\nElija un tipo: ");
                    
                    try{    
                        tipo=MyInput.readInt();
                         if(tipo>3 || tipo<1){
                             throw new Excepcion("Error. El número introducido ha de ser 1 ó 3");
                         }

                     }
                     catch(Excepcion e){
                         excepcion = true;
                         System.out.println(e.getMessage());

                     }
                     catch(NumberFormatException nfe){
                         excepcion = true; 
                         System.out.println("Error. Debe introducir un número, no un caracter");
                     }
           
                }while(excepcion==true);
                
                
                if(tipo==3){
                    clase="Doble";
                    /*System.out.println("La eleccion ha sido una habitacion Doble.");
                    System.out.println("¿Deseas que sea baño propio o baño individual?");
                    System.out.println("s:deseas baño individual, n:deseas baño compartido");
                    respuesta=teclado.next().charAt(0);
                    if(respuesta=='s'){
                        baño=true;
                    }else{
                        baño=false;
                    }*/
                }
                if(tipo==2){
                     clase="Individual";
                }else{
                     clase="Familiar";
                }
                
                
                 switch(tipo){
                    case 1: habitacion = new Familiar(numHabitacion,precio,baño);
                            balneario.altaHabitacion(habitacion);
                        break;  
                    case 2: habitacion = new Individual(numHabitacion,precio,baño);
                            balneario.altaHabitacion(habitacion);
                        break; 
                    case 3: habitacion = new Doble(numHabitacion,precio,baño);
                            balneario.altaHabitacion(habitacion);
                        break;  
                     }
                 
                 //falta de meter el baño y la cama supletoria esto no se si lo tenemos que poner cuando se hacen la reserva de habitacion
                    
                 
                 /*if(tipo==1){
                     System.out.println("Tu eleccion ha sido la habitacion Familiar puedes optar a cama supletoria");
                     System.out.println("¿Cuantas Camas Supletorias desea?");
                     camas=MyInput.readInt();
                     
                     for(int j=0;j<camas;j++){
                         habitacion= new CamaSupletoria(numHabitacion,precio);
                     }
 
                 }else{if(tipo==3){
                     System.out.println("Tu eleccion ha sido la habitacion Doble puedes optar a baño individual");
                     System.out.println("¿Deseas un Baño Individual?(S/N)");
                     baño = teclado.next().charAt(0);
                     
                     if(baño=='S'|| baño=='s'){
                        habitacion=new Baño(numHabitacion,precio);
                     }else{
                         System.out.println("No se desea baño individual. Tus datos son estos:");
                     }
                     
                        }else
                            System.out.println("Tu eleccion ha sido la habitacion Individual no puedes optar a cama supletoria ni baño individual");   
                 }*/
                 
        
        
        
    
    }
        
        
    public static void menueEliminarHabitacion(Balneario balneario){
        
        
        int i,numHabitacion;
        
        System.out.println("Introduce el numero de la habitacion a eliminar:");
        numHabitacion=MyInput.readInt();
        
        balneario.eliminarHabitacion(numHabitacion);

        
    }
    
    
    public static void menuObtenerListadoHabitaciones(Balneario balneario){
        
        
        int i;
        System.out.println();
        System.out.println();
        for(i=0;i<balneario.get_array().size();i++){
            System.out.println("La habitacion en la posicion numero:"+i);
            System.out.println("Numero Habitacion: "+balneario.get_array().get(i).get_numHabitacion());
            System.out.println("Precio por Noche:"+balneario.get_array().get(i).get_precio());
        } 

    
    }
 
    
    
    public static void menuMostrarInfoHabitacion(Balneario balneario){
        
        //Habitaciones habitacion ;
        int numero;
        
        System.out.println("Introduce el numero de la habitacion:");
        numero=MyInput.readInt();
        
        balneario.mostrarInfoHabitacion(numero);
          
    }
    
    
    public static void menuAñadirCliente(Balneario balneario){
        
        Cliente cliente;
        String nombre= "", apellidos= "", Dni="",telefono="";

        String respuesta="";
        boolean dnivalido=false;

        do{
            System.out.println("Has entrado en Alta Cliente");
            System.out.println("Introduczca los siguientes datos:");
            System.out.println("Introduzca el nombre");
            nombre=MyInput.readString();
            
            System.out.println("Introduzca los apellidos");
            apellidos=MyInput.readString();
            
            do{
                
            System.out.println("Introduzca el DNI");
            Dni= MyInput.readString();
            dnivalido= balneario.validar_dni(Dni);
            
            }while(dnivalido==false);
            
            
            System.out.println("Introduzca el telefono");
            telefono=MyInput.readString();
            
            System.out.println("DATOS DEL CLIENTE");
            System.out.println("El nombre introducido es" +nombre);
            System.out.println("Los apellidos introducidos son:"+apellidos);
            System.out.println("El DNI introducido es:"+Dni);
            System.out.println("El telefono introducido es:"+telefono);
            
            System.out.println("¿Los datos introducidos son correctos?(si/no)");
            
            respuesta=  MyInput.readString();
            respuesta=respuesta.toLowerCase();
            
        }while((respuesta.equals("no")));
        cliente=new Cliente(nombre,apellidos,Dni,telefono);
        balneario.AltaCliente(cliente);
        
    }
    
     public static void menuEliminarCliente(Balneario balneario){
         
        String DNI;

        System.out.println("Bienvenido a eliminar cliente");
        System.out.println("Introduzca el Dni del cliente a eliminar");
        DNI=MyInput.readString();

        balneario.eliminarCliente(DNI);
     
     }
     
    
    public static void menuObtenerListadoClientes(Balneario balneario){
    
        int i;
        System.out.println();
        System.out.println();
        for(i=0;i<balneario.getCliente().size();i++){
            System.out.println("El cliente en la posicion numero:"+i);
            System.out.println("Dni del cliente: "+balneario.getCliente().get(i).Dni);
            System.out.println("Nombre del cliente:"+balneario.getCliente().get(i).nombre+ balneario.getCliente().get(i).apellidos);
            System.out.println("Telefono del cliente: "+balneario.getCliente().get(i).telefono);
        } 
            
    }
     
    
    public static void menuMostrarInfoCliente(Balneario balneario){
      
        String dni;
        
        System.out.println("Introduce el Dni del cliente:");
        dni=MyInput.readString();
        
        balneario.mostrarInfoCliente(dni);
        
    }
    
    
    public static void menuGenerarFacturas(Balneario balneario){
        
        Facturacion facturas;
        int numHab;
        String Codigo="",cliente="";
        int codigo;
        float costeTotal=0;
        LocalDate fechaFact;
        int dia,mes,anno;
        int numReserva []=new int[5];
        int posicion;

        //EL codigo no funciona bien
        Codigo="00000000";
        codigo= Integer.parseInt(Codigo);
        codigo++;
        Codigo=String.valueOf(codigo);
        
       
            System.out.println("Introduce el numero de la habitacion para realizar la factura");
            numHab=MyInput.readInt();
            
            System.out.println("Introduce el Dni del cliente");
            cliente=MyInput.readString();
            
        do{      

            System.out.println("Dia de Fcaturacion:");
            dia=MyInput.readInt();
            System.out.println("Mes de Fcaturacion:");
            mes=MyInput.readInt();
            System.out.println("Año de Fcaturacion:");
            anno=MyInput.readInt();


            fechaFact=LocalDate.of(anno,mes,dia);
        
        }while(balneario.fechaFact(fechaFact, numHab)==false);
        
        System.out.println("La fecha es valida");
        
        for(int i=0;i<balneario.array_reserva().size();i++){
            if(numHab==balneario.array_reserva().get(i).numHabitacion){
                if(cliente.equals(balneario.array_reserva().get(i).cliente)){
                //if((fechaFact.isBefore(balneario.array_reserva().get(i).diaFin))||(fechaFact.equals(balneario.array_reserva().get(i).diaFin))){
                    numReserva[i]=balneario.array_reserva().get(i).numReserva;
                    costeTotal=costeTotal+balneario.costeTotal(numReserva[i],fechaFact);
                    posicion=balneario.posicionFacturas();
                    
                    if((posicion>=0)||(posicion<=9)){
                        Codigo="0000000"+-posicion;
                    }else{
                        Codigo="000000"+-posicion;
                    }
                    
                            
                    
                  
                    //cliente=balneario.array_reserva().get(i).cliente;
                //}
                }
            }
        }
        
        if(balneario.descuento(anno, cliente)==true){ 
            costeTotal=(float) (costeTotal*0.95);
            System.out.println("El descuento del 5% ha sido aplicado.Gracias por su confianza"); 
        }else{
            System.out.println("El descuento no se ha aplicado"); 
        }
      
        
        
        //Parece que el precio si que funciona pero hay que probar con la misma habitacion otro dia reservada
        //Y tambien meter mas servicios de spa
        System.out.println("Estos son los datos de la factura:");
        System.out.println("Codigo  "  +Codigo);
         System.out.print("Los numeros de Reserva son:");
        for(int j=0;j<numReserva.length;j++)
            System.out.print(" "+numReserva[j]);
        System.out.println("");
        System.out.println("Cliente  " +cliente);
        System.out.println("Coste Total   "   +costeTotal);
        System.out.println("Fecha    "     +fechaFact);
        
        
        facturas=new Facturacion(Codigo,cliente,costeTotal,fechaFact);
        balneario.AltaFacturas(facturas);
        
        for(int k=0;k<numReserva.length;k++)
            balneario.eliminarReserva(numReserva[k]);
        
    }
    
    
    public static void menuMostrarListadoFacturas(Balneario balneario){
        
        balneario.MostrarFacturas();

    }
    
    
    public static void menuMostrarInfoFactura(Balneario balneario){
        
        String codigo;
        
        System.out.println("Introduzca el codigo de la factura");
        codigo= MyInput.readString();
        balneario.MostrarFactura(codigo);
        
        
    }
   
    
    public static void menuAñadirServicioSpa(Balneario balneario){
       
        ServicioSpa spa;
        String Codigo="",descripcion="";
        float coste=0;
        boolean excepcion;
        
        Scanner teclado = new Scanner(System.in);

        
        System.out.println("Has entrado en el Menu de añadir Servicio de Spa");
        excepcion=false;

                System.out.println("Introduce el codigo del servicio");
                Codigo=MyInput.readString();
                System.out.println("Introduce una descripcion del servicio");
                descripcion=MyInput.readString();
                System.out.println("Introduce el coste del servicio");
                coste= MyInput.readFloat();
                

                spa=new ServicioSpa(Codigo,descripcion,coste);           
                balneario.añadirServicio(spa);
                
   
    }
    
    
    public static void  menuElimiarServicioSpa(Balneario balneario){
        
        int i;
        String codigo;
        
        System.out.println("Introduce el numero del servicio spa a eliminar:");
        codigo=MyInput.readString();
        
        balneario.eliminarServicoSpa(codigo);
        
        
    }
    
    
    public static void menuObtenerListadoServicioSpa(Balneario balneario){
        
        int i;
        System.out.println();
        System.out.println();
        for(i=0;i<balneario.get_array_spa().size();i++){
            System.out.println("El spa en la posicion numero:"+i);
            System.out.println("Codigo:"+balneario.get_array_spa().get(i).Codigo);
            System.out.println("Coste:"+balneario.get_array_spa().get(i).coste);
            System.out.println("Descripcion"+balneario.get_array_spa().get(i).descripcion); 
        } 

    }
    
    
    public static void menuMostrarInfoServicioSpa(Balneario balneario){
        
        String codigo;
        
        System.out.println("Introduce el codigo del Servicio de Spa");
        codigo=MyInput.readString();
        
        balneario.obtenerInfoServicio(codigo);
  
        
    }
    
    public static void menuAnnadirReserva(Balneario balneario){
       
        int opcion;
        
        do{
            int numReserva = balneario.array_reserva().size();
            
            opcion = -1; 
            System.out.println("Menú para añadir reserva");
            System.out.println("\n\t1.- Crear una reserva de Habitacion");
            System.out.println("\t2.- Crear una reserva de Spa");
            System.out.println("\t0.- Salir de reservas");

            System.out.println("Elija una de las opciones: ");
            try{
                opcion = MyInput.readInt();
                
                if(opcion<0 || opcion>4){
                    throw new Excepcion("EL numero debe estar entre 1 y 4");
                }
            }
            catch(Excepcion e){
                System.out.println(e.getMessage());
            }
            catch(NumberFormatException nfe){
                System.out.println("Error. Debe introducir un número, no un caracter");
            }
            
            switch(opcion){
                case 1: menuAnnadirReservaHabitacion(balneario,numReserva); 
                    break; 
                case 2: menuannadirReservaSpa(balneario,numReserva); 
                    break; 
                case 0: System.out.println("Estas volviendo al Menu de Reservas");
                    break; 
            }
            
        }while(opcion != 0);
    
    
    }


    public static void menuAnnadirReservaHabitacion(Balneario balneario,int numReserva){
        
        Reservas reserva;
        Habitaciones h = null;
        int numHabitacion = 0;
        int diai = 0,mesi = 0,anoi = 0;
        int diaf = 0,mesf = 0,anof = 0;
        LocalDate diaInicio,diaFin;
        long dias=0;
        float coste = 0;
        float extra = 0;
        int tipo = 0;
        float camas=0;
        boolean excepcion = false;
        char respuesta;
        boolean baño = false;
        String cliente="";
        boolean dnivalido;
        boolean alta = false;
        boolean fecha = true;
        boolean fechavalida=false;

        Scanner teclado = new Scanner(System.in);
        
        
        do{
                
            System.out.println("Introduzca el DNI");
            cliente= MyInput.readString();
            dnivalido = balneario.validar_dni(cliente);

        }while((dnivalido==false));

        
        
        alta=balneario.existeCliente(cliente);
        
        if((alta==true)){
            do{
                System.out.println("Que Habitacion deseas:");
                do{

                        System.out.println("Tipo de Habitacion");
                        System.out.println("\t\t1.- Familiar");
                        System.out.println("\t\t2.- Individual");
                        System.out.println("\t\t3.- Doble");
                        System.out.println("\nElija un tipo: ");

                        try{    
                            tipo=MyInput.readInt();
                             if(tipo>3 || tipo<1){
                                 throw new Excepcion("Error. El número introducido ha de ser 1 ó 3");
                             }

                         }
                         catch(Excepcion e){
                             excepcion = true;
                             System.out.println(e.getMessage());

                         }
                         catch(NumberFormatException nfe){
                             excepcion = true; 
                             System.out.println("Error. Debe introducir un número, no un caracter");
                         }

                }while(excepcion==true);

                    balneario.ListaHabitacion(tipo);



                    do{
                        System.out.println("Seleccione la Habitacion de la lista que prefiera:");
                        numHabitacion=MyInput.readInt();
                    }while(balneario.comprobarHabitacion(tipo, numHabitacion)==false);
                    
                    for(int y=0;y<balneario.get_array().size();y++){
                        if(numHabitacion==balneario.get_array().get(y).numHabitaciones){
                            h= new Habitaciones(balneario.get_array().get(y).numHabitaciones,balneario.get_array().get(y).precio,balneario.get_array().get(y).baño);
                            coste=balneario.get_array().get(y).precio;
                        }
                    }
                    
                    if(tipo==3){
                        System.out.println("La eleccion ha sido una habitacion Doble.");
                        System.out.println("¿Deseas que sea baño propio o baño individual?");
                        System.out.println("s:deseas baño compratido, n:deseas baño individual");
                        respuesta=teclado.next().charAt(0);
                        if(respuesta=='s'){
                            baño=true;
                        }else{
                            baño=false;
                        }
                    }
                    if(tipo==1){
                        System.out.println("La eleccion ha sido una habitacion Familiar.");
                        System.out.println("¿Deseas alguna cama Supletoria?(Tiene un 20% mas de coste)");
                        System.out.println("s:deseas camas, n:no deseas camas");
                        respuesta=teclado.next().charAt(0);
                        if(respuesta=='s'){
                            h=balneario.CamasSupletorias(h);//No calcula el precio extra de la habitacion por tener la cama
                            camas=(float) (h.get_precio()-balneario.costeHabitacion(numHabitacion));
                            System.out.println("El precio de la/las camas es:"+camas);
                        }
                    }
                    
                    do{
                        
                    
                    System.out.println("Dia de Inicio de la reserva:");
                    diai=MyInput.readInt();
                    System.out.println("Mes de Inicio de la reserva:");
                    mesi=MyInput.readInt();
                    System.out.println("Año de Inicio de la reserva:");
                    anoi=MyInput.readInt();
                    
                   
                    diaInicio=LocalDate.of(anoi,mesi,diai);
                    
                    

                    System.out.println("Dia de Fin de la reserva:");
                    diaf=MyInput.readInt();
                    System.out.println("Mes de Fin de la reserva:");
                    mesf=MyInput.readInt();
                    System.out.println("Año de Fin de la reserva:");
                    anof=MyInput.readInt();

                    diaFin=LocalDate.of(anof,mesf,diaf);
                    dias=diaf-diai;
                    fechavalida=balneario.validarfecha(diaInicio,diaFin);
                   
                    }while(fechavalida==false);
                    
                    System.out.println("El numero de dias que dispondras de la habitacion es :   "      +dias);
                    if(numReserva>0){//no funciona como deberia funcionar el metodo no compara bien la fecha
                        fecha=balneario.compararfecha(numHabitacion, diaInicio, diaFin);
                        fecha=true;
                    }
                     
                    if(fecha==true)
                        System.out.println("FECHA DISPONIBLE!!");
                    else
                        System.out.println("La fecha no esta disponible ya hay reserva realizada");

                }while(fecha==false);

            
            
                if(fecha==true){

                    coste= dias*balneario.costeHabitacion(numHabitacion);
                    coste=coste+camas;
                    
                    if(baño==true){
                        System.out.println("El precio de la habitacion ha aumnetado en un 15%");
                        extra=(float) (coste*0.15);
                        System.out.println("El precio extra de la habitacion es:"+extra);
                        coste=coste+ extra;
                    }
                    

                    numReserva++;

                     System.out.println("Datos de la Reserva de Habitacion");
                     System.out.println("Numero de reserva:"+numReserva);
                     System.out.println("Numero de Habitacion:"+numHabitacion);
                     System.out.println("Fechas de la reserva:"+diaInicio+ "/" +diaFin);
                     System.out.println("Precio de la Reserva:"+coste);
                     System.out.println("Cliente con Dni"+cliente);


                    reserva=new ReservaHabitacion(numReserva, numHabitacion, coste, diaInicio,diaFin,cliente);
                    
                    balneario.annadirReservaHabitacion(reserva);

            }   
    
    }
        
}
    
/*IMPORTANTE*/  
    //Solo puede haber una reserva de un nuemor de habiatacion antes de eliminar la reserva
 //NO se puede hacer una reserva de habitacion y despues una de spa
    //Hay que salirse al menu de reservas porque si no el numero de reservas no se actualiza
    
    
    public static void menuannadirReservaSpa(Balneario balneario,int numReserva){
        
        Reservas reservaSpa;
        String codigo = null;
        int personas = 0;   
        int numHabitacion ;
        int diai = 0,mesi = 0,anoi = 0;
        LocalDate diaInicio,diaFin = null;
        float coste;
        String cliente="";
        boolean dnivalido;

        
        do{
                
            System.out.println("Introduzca el DNI");
            cliente= MyInput.readString();
            dnivalido = balneario.validar_dni(cliente);

        }while((dnivalido==false));
          
            //No reconoce la habitacion que tiene el cliente(Si que va pero puede dar problemas)
            //Se borran las reservas de una ejeccuicion a otra
            //Hay que unir reserva de Habitacion con las reservas de spa
            numHabitacion=balneario.clienteHabitacion(cliente);//Localizar la habitacion del cliente

            if(numHabitacion>0){
            
                System.out.println("Dia de Inicio de la reserva:");
                diai=MyInput.readInt();
                System.out.println("Mes de Inicio de la reserva:");
                mesi=MyInput.readInt();
                System.out.println("Año de Inicio de la reserva:");
                anoi=MyInput.readInt();

                diaInicio=LocalDate.of(anoi,mesi,diai);


                System.out.println("Para ese dia tenemos disponible los siguientes servicio de Spa:");
                for(int j=0;j<balneario.get_array_spa().size();j++){
                    if(diaInicio.equals(balneario.array_reserva().get(j).diaInicio)){
                        System.out.println();

                    }else{
                        System.out.println("Datos del Servicio en la posicion:"+j);
                        System.out.println("Codigo:"+balneario.get_array_spa().get(j).Codigo);
                        System.out.println("descripcion:"+balneario.get_array_spa().get(j).descripcion);
                        System.out.println();
                    }
                }

                System.out.print("Seleccion un codigo de los mostrados anteriormente:");
                codigo=MyInput.readString();
                
                balneario.validarfechaspa(numHabitacion,diaInicio);
                
                
                numReserva++;
                coste= balneario.costeServicio(codigo);
                System.out.println("Datos de la Reserva de Habitacion");
                System.out.println("Numero de reserva:"+numReserva);
                System.out.println("Numero de Habitacion:"+numHabitacion);
                System.out.println("Codigo del Spa:"+codigo); 
                System.out.println("Fecha de la reserva:"+diaInicio);
                System.out.println("Precio de la Reserva:"+coste);
                 
                reservaSpa=new ReservaSpa( numReserva, numHabitacion, coste, diaInicio,diaFin,cliente,codigo,personas);

                balneario.annadirReservaSpa((ReservaSpa) reservaSpa);
            }else{
                 System.out.println("Este cliente no tiene ninguna habitacion a su cargo");
            
            }
    
    
    }
    
    
   public static void menuEliminarReserva(Balneario balneario){
       
        int numReserva;
        
        
       
        System.out.println("Introduce el numero de la reserva a eliminar:");
        numReserva=MyInput.readInt();
        
        balneario.eliminarReserva(numReserva);
        
   
   }
    
   public static void menuMostarReservas(Balneario balneario){
         
       balneario.menuMostarReservas();
   }
   
   public static void menuMostarInfoReserva(Balneario balneario){
       
       int numReserva = 0;
       
       
               
        System.out.println("Introduce el numero de la reserva:");
        numReserva=MyInput.readInt();
        
        balneario.mostrarInfoReserva(numReserva);
        
        
   
   }
   
   
    public static void cerrarPrograma(){
        System.out.println("\nHas elegido salir del programa");
        System.out.println("Gracias por utilizar la aplicación");
    }
  
}
