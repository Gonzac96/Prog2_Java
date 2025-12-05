import Modelo.*;
import Negocio.*;
import Vista.Menu;
import Dato.*;
import Excepciones.*;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        
        // 1. Inicialización de las distintas clases
        Concesionaria concesionaria = new Concesionaria(); // Concesionaria con datos por defecto

        // Taller genérico
        Taller <Vehiculo> taller = new Taller<>();

        Menu menu = new Menu();
        boolean continuar = true;

        System.out.println("\n\tBienvenido al Sistema de Gestión de la Concesionaria!");

        // 2. Bucle principal del menú
        while (continuar) {
            menu.mostrarMenuPrincipal();
            int opcion = menu.leerOpcion();

            try {
                switch (opcion) {
                    case 1:
                        // Lógica para agregar nuevo vehículo
                        agregarNuevoVehiculo(menu, concesionaria);
                        break;
                    case 2:
                        // Lógica para ver inventario completo
                        concesionaria.mostrarInventario();
                        break;
                    case 3:
                        // Lógica para buscar vehículos por MODELO
                        String modeloBuscado = menu.leerDatoString("Ingrese el modelo a buscar");
                        List<Vehiculo> resultados = concesionaria.buscarVehiculoPorModelo(modeloBuscado);

                        System.out.println("Resultados de búsqueda para el modelo '" + modeloBuscado + "':");
                        if (resultados.isEmpty()) {
                            System.out.println("No se encontraron vehículos del modelo especificado.");
                        } else {
                            for (Vehiculo vehiculo : resultados) {
                                System.out.println(vehiculo);
                            }
                        }
                        break;
                    case 4:
                        // Lógica para eliminar vehículo
                        String modeloAEliminar = menu.leerDatoString("Ingrese el modelo del vehículo a eliminar");
                        List<Vehiculo> vehiculosAEliminar = concesionaria.buscarVehiculoPorModelo(modeloAEliminar);

                        if (vehiculosAEliminar.isEmpty()) {
                            System.out.println("No se encontraron vehículos con el modelo especificado.");
                        } else {
                            // se elimina el primer vehículo encontrado con ese modelo
                            concesionaria.eliminarVehiculo(vehiculosAEliminar.get(0));
                        }
                        break;
                    case 5:
                        // Lógica para ingresar vehículo usado al taller
                        System.out.println("--- Ingresando vehículo usado al taller ---");
                        // 1. La lista filtrada
                        List<Vehiculo> aMantenimiento = concesionaria.obtenerVehiculosParaMantenimiento();

                        if (aMantenimiento.isEmpty()) {
                            System.out.println("No hay vehículos usados pendientes de mantenimiento.");
                        } else {
                            System.out.println("Seleccione el vehículo a ingresar:");
                            
                            // Se muestra la lista numerada
                            for (int i = 0; i < aMantenimiento.size(); i++) {
                                System.out.println((i + 1) + ". " + aMantenimiento.get(i).toString());
                            }
                            System.out.println("0. Cancelar");

                            // Leemos la opción del usuario
                            int seleccion = menu.leerOpcion();

                            if (seleccion > 0 && seleccion <= aMantenimiento.size()) {
                                // Obtenemos el vehículo real (indice - 1)
                                Vehiculo vSeleccionado = aMantenimiento.get(seleccion - 1);
                                
                                // Lo mandamos al taller
                                taller.ingresarVehiculo(vSeleccionado);
                                
                                System.out.println("Vehículo " + vSeleccionado.getModelo() + " ingresado a la cola del taller.");
                            } else if (seleccion != 0) {
                                System.out.println("Opción inválida.");
                            }
                        }
                        break;
                        // Creo auto usado para pruebas
                        // try{
                        //     Auto autoUsado = new Auto(Marca.FORD, "Focus", 2015, Color.GRIS_OSCURO, true, 3500000, TipoCarroceria.SEDAN, 4);
                        //     taller.ingresarVehiculo(autoUsado);
                        // } catch (AutoCantPuertasException e){
                        //     System.out.println(e.getMessage());
                        // }
                        // Vehiculo vehiculoParaTaller = null;
                        // for (Vehiculo v : concesionaria.getInventario()) {
                        //     if (v.isEsUsado()) {
                        //         vehiculoParaTaller = v;
                        //         break;
                        //     }
                        // }
                        // if (vehiculoParaTaller != null) {
                        //     taller.ingresarVehiculo(vehiculoParaTaller);
                        //     System.out.println("Vehículo usado ingresado al taller: " + vehiculoParaTaller.getModelo());
                        // } else {
                        //     System.out.println("No hay vehículos usados disponibles en el inventario para ingresar al taller.");
                        // }
                        // break;
                    case 6:
                        // Lógica para procesar siguiente vehículo en taller
                        System.out.println("--- Procesando siguiente vehículo en el taller ---");
                        System.out.println("Vehículo en cola: " + taller.contarVehiculosEnCola());
                        taller.atenderSiguienteVehiculo();
                        break;
                    case 7:
                        // Cargar datos de prueba
                        cargarDatosDePrueba(concesionaria);
                        break;
                    case 8: 
                        // Lógica para mostrar información de contacto de la concesionaria
                        System.out.println("--- Información de Contacto de la Concesionaria ---");
                        System.out.println(concesionaria.obtenerInformacionContacto());
                        break;
                    case 0:
                        // Salir del programa
                        System.out.println("Gracias por utilizar el sistema. ¡Hasta luego!");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción del menú.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        menu.cerrarScanner();        
    }

    // Método para agregar un nuevo vehículo
    public static void agregarNuevoVehiculo(Menu menu, Concesionaria concesionaria) {
        System.out.println("\n--- Seleccione el tipo de vehículo ---");
        System.out.println("1. Auto");
        System.out.println("2. Moto");
        System.out.println("3. Camioneta");
        int tipoVehiculo = menu.leerOpcion();

        try {
            // // Hardcodeo para agilizar la carga de datos
            // Marca marca = Marca.TOYOTA;
            // String modelo = menu.leerDatoString("Ingrese el modelo del vehículo").toUpperCase();
            // int anio = 2025;
            // Color color = Color.NEGRO;
            // boolean esUsado = false;
            // double precio = menu.pedirDatoDouble("Ingrese precio");

            Marca marca = elegirEnum(menu, Marca.values(), "Marca");
            String modelo = menu.leerDatoString("Ingrese el modeloaasdasda").toUpperCase();
            int anio = (int) menu.pedirDatoDouble("Ingrese el año de fabricación");
            Color color = elegirEnum(menu, Color.values(), "Color");
            boolean esUsado = preguntarEsUsado(menu);
            double precio = menu.pedirDatoDouble("Ingrese precio");

            switch (tipoVehiculo) {
                case 1: // AUTO
                    System.out.println("Creando Auto");
                    TipoCarroceria carroceria = elegirEnum(menu, TipoCarroceria.values(), "Carrocería");
                    int puertas = (int) menu.pedirDatoDouble("Cantidad de puertas");

                    Auto nuevoAuto = new Auto(marca, modelo, anio, color, esUsado, precio, carroceria, puertas);
                    concesionaria.agregarVehiculo(nuevoAuto);
                    break;

                case 2: // MOTO
                    System.out.println("Creando Moto");
                    TipoMoto tipoMoto = elegirEnum(menu, TipoMoto.values(), "Tipo de Moto");
                    int cilindrada = (int) menu.pedirDatoDouble("Cilindrada (cc)");

                    Moto nuevaMoto = new Moto(marca, modelo, anio, color, esUsado, precio, tipoMoto, cilindrada);
                    concesionaria.agregarVehiculo(nuevaMoto);
                    break;

                case 3: // CAMIONETA
                    System.out.println("Creando Camioneta");
                    TipoCarroceria carroceriaCamioneta = elegirEnum(menu, TipoCarroceria.values(), "Carrocería");
                    double capacidadCarga = menu.pedirDatoDouble("Capacidad de carga (kg)");
                    int personas = (int) menu.pedirDatoDouble("Cantidad de personas");
                    String traccion = menu.leerDatoString("Tipo de tracción (ej. 4x2, 4x4)");

                    Camioneta nuevaCamioneta = new Camioneta(marca, modelo, anio, color, esUsado, precio, carroceriaCamioneta, capacidadCarga, personas, traccion);
                    concesionaria.agregarVehiculo(nuevaCamioneta);
                    break;

                default:
                    System.out.println("Tipo de vehículo inválido.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
        } catch (AutoCantPuertasException e) {
            System.out.println("Error al crear el auto: " + e.getMessage());
        } catch (CilindradaInvalidaException e) {
            System.out.println("Error al crear la moto: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al crear el vehículo: " + e.getMessage());
        }


    }

    // Método para cargar datos falsos (Mock Data) para pruebas
    public static void cargarDatosDePrueba(Concesionaria concesionaria) {
        System.out.println("--- Cargando datos de prueba... ---");
        try {
            // Autos
            Auto a1 = new Auto(Marca.TOYOTA, "COROLLA", 2020, Color.BLANCO, true, 18000, TipoCarroceria.SEDAN, 4);
            Auto a2 = new Auto(Marca.FORD, "FIESTA", 2018, Color.AZUL, true, 12000, TipoCarroceria.OTRO, 5);
            Auto a3 = new Auto(Marca.FIAT, "CRONOS", 2024, Color.ROJO, false, 22000, TipoCarroceria.SEDAN, 4);
            
            // Motos
            Moto m1 = new Moto(Marca.HONDA, "WAVE", 2023, Color.NEGRO, false, 2000, TipoMoto.STREET, 110);
            Moto m2 = new Moto(Marca.YAMAHA, "TENERE", 2015, Color.AZUL, true, 9000, TipoMoto.CUSTOM, 250);

            // Camioneta
            Camioneta c1 = new Camioneta(Marca.TOYOTA, "HILUX", 2019, Color.GRIS, true, 35000, TipoCarroceria.PICKUP, 1000, 5, "4x4");

            concesionaria.agregarVehiculo(a1);
            concesionaria.agregarVehiculo(a2);
            concesionaria.agregarVehiculo(a3);
            concesionaria.agregarVehiculo(m1);
            concesionaria.agregarVehiculo(m2);
            concesionaria.agregarVehiculo(c1);

            System.out.println("Se han cargado 6 vehículos de prueba exitosamente.");

        } catch (Exception e) {
            System.out.println("Error al cargar datos de prueba: " + e.getMessage());
        }
    }

    // Método genérico para elegir un ENUM
    public static <T> T elegirEnum(Menu menu, T[] opciones, String nombreAtributo) {
        System.out.println("\n--- Seleccione " + nombreAtributo + " ---");
        for (int i = 0; i < opciones.length; i++) {
            // Mostramos: 1. TOYOTA, 2. FORD...
            System.out.println((i + 1) + ". " + opciones[i]);
        }
        
        int seleccion = 0;
        // Validamos que elija un número dentro del rango
        while (seleccion < 1 || seleccion > opciones.length) {
            seleccion = menu.leerOpcion();
            if (seleccion < 1 || seleccion > opciones.length) {
                System.out.println("Opción inválida. Elija entre 1 y " + opciones.length);
            }
        }
        // Retornamos el valor real (restamos 1 porque el array empieza en 0)
        return opciones[seleccion - 1];
    }

    // Método auxiliar para preguntar si es usado o nuevo
    public static boolean preguntarEsUsado(Menu menu) {
        System.out.println("\n--- ¿Condición del vehículo? ---");
        System.out.println("1. Nuevo (0 km)");
        System.out.println("2. Usado");
        int opcion = 0;
        while (opcion != 1 && opcion != 2) {
            opcion = menu.leerOpcion();
            if (opcion != 1 && opcion != 2) System.out.println("Elija 1 o 2.");
        }
        return (opcion == 2); // Si eligió 2, retorna true (es usado)
    }


}

