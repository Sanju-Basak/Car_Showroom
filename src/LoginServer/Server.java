package LoginServer;

import DataCar.Car;
import DataCar.CarList;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server
{
    public HashMap<String, String> userMap;

    public static void main(String[] args) throws Exception{
        Server server1= new Server();
        server1.userMap= new HashMap<>();
        server1.userMap.put("Sanju", "123");
        server1.userMap.put("Masum", "1123");
        server1.userMap.put("Partha", "1123");
        server1.userMap.put("Dip", "456");
        server1.userMap.put("Anu", "789");
        CarList carList1= new CarList();
        carList1.readCarsFromFile();
        ServerSocket server= null;
        Socket clientSocket= null;
        try {
            server= new ServerSocket(44444);
            while (true)
            {
                clientSocket= server.accept();
                Socket finalclientSocket= clientSocket;
                new Thread(){
                    @Override
                    public void run(){
                        try {
                            ObjectOutputStream oos = new ObjectOutputStream(finalclientSocket.getOutputStream());
                            ObjectInputStream ois = new ObjectInputStream(finalclientSocket.getInputStream());
                            while (true) {
                                Object o= (Object) ois.readUnshared();
                                //String s = (String) o;
                                //String[] str = s.split(",");
                                if(o != null){
                                    if(o instanceof LoginDTO)
                                    {
                                        LoginDTO loginDTO = (LoginDTO) o;
                                        String password = server1.userMap.get(loginDTO.getUserName());
                                        loginDTO.setStatus(loginDTO.getPassword().equals(password));
                                        oos.writeUnshared(loginDTO);
                                    }
                                    else
                                    {
                                        String s= (String) o;
                                        System.out.println(s);
                                        String[] str = s.split(",");
                                        if(str[0].equalsIgnoreCase("regNum"))
                                        {
                                            int i= carList1.SearchByReg(str[1]);
                                            System.out.println(i);
                                            if(i== -1)
                                                oos.writeUnshared("Not found!!");
                                            else
                                            {
                                                Car c= carList1.carList.get(i);
                                                String s3= c.toString();
                                                System.out.println(s3);
                                                oos.writeUnshared(s3);
                                            }
                                        }
                                        else if(str[0].equalsIgnoreCase("CarMake&Model"))
                                        {
                                        String s3= carList1.SearchByCarMake_CarModel(str[1], str[2]);
                                        oos.writeUnshared(s3);
                                        }
                                        else if(str[0].equalsIgnoreCase("deleteCar"))
                                        {
                                            oos.writeUnshared(carList1.deleteCar(str[1]));
                                        }
                                        else if(str[0].equalsIgnoreCase("viewCar"))
                                        {
                                            String s2= "";
                                             for(int i=0; i<carList1.carList.size(); i++)
                                            {
                                                Car c= carList1.carList.get(i);
                                                s2= s2 + c.toString();
                                                s2= s2+ "\n";
                                            }
                                        oos.writeUnshared(s2);
                                        }
                                        else if(str[0].equalsIgnoreCase("BuyCar"))
                                        {
                                            oos.writeUnshared(carList1.buyCar(str[1]));
                                        }
                                        else if (str[0].equalsIgnoreCase("addCar")) {
                                            oos.writeUnshared(carList1.addCar(s));
                                        }
                                        else if(str[0].equalsIgnoreCase("EditCar")) {
                                            System.out.println("In edit car");
                                            int i = carList1.SearchByReg(str[1]);
                                            Car c1 = carList1.carList.get(i);
                                            String str4 = c1.toString();
                                            System.out.println(str4);
                                            oos.writeUnshared(str4);
                                        }
                                        else if(str[0].equalsIgnoreCase("EditCar2"))
                                        {
                                            System.out.println("In edit car2");

                                            System.out.println(str[0]);
                                            Car c= new Car(str[1],Integer.parseInt(str[2]),str[3],str[4],str[5],
                                                    str[6],str[7],Integer.parseInt(str[8]),Integer.parseInt(str[9]));
                                            int i= carList1.SearchByReg(str[1]);
                                            carList1.carList.set(i,c);


                                        }

                                    }
                                }
                            }
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
                server.close();
        }
    }
}

