package DataCar;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CarList implements Serializable {
    private static final String INPUT_FILE_NAME = "cars.txt";

    public List<Car> carList= new ArrayList();
    public int SearchByReg(String reg)
    {
        int strIndex= -1;
        for(int i=0; i< carList.size(); i++)
        {
            Car comp= carList.get(i);
            if(comp.getCarReg().equalsIgnoreCase(reg))
                strIndex= i;
        }
        return strIndex;
    }

    public String SearchByCarMake_CarModel(String carMake, String carModel)
    {
        String str= "";
        if(carModel.equalsIgnoreCase("Any"))
        {
            for(int i=0; i< carList.size(); i++)
            {
                Car c= carList.get(i);
                if(c.getCarMake().equalsIgnoreCase(carMake))
                {
                    str= str+ c.toString()+ "\n";
                }
            }
        }
        else
        {
            for (int i=0; i< carList.size(); i++)
            {
                Car c= carList.get(i);
                if(c.getCarModel().equalsIgnoreCase(carModel))
                {
                    str= str+ c.toString();
                }
            }
        }
        return str;
    }

    public boolean addCar(String info)
    {
        String [] values= info.split(",");
        if(values.length < 9)
            return false;
        Car c= new Car(values[1], Integer.parseInt(values[2]), values[3], values[4],
                values[5], values[6], values[7], Integer.parseInt(values[8]),Integer.parseInt(values[9]));
        int x= SearchByReg(c.getCarReg());
        if(x !=-1)
            return false;
        else
        {
            carList.add(c);
            return true;
        }
    }

    public boolean deleteCar(String reg)
    {
        int x;
        x= SearchByReg(reg);
        if(x != -1)
        {
            carList.remove(x);
            return true;
        }
        else
            return false;
    }

    public boolean buyCar(String reg)
    {
        int x,y;
        x= SearchByReg(reg);
        if(x != -1)
        {
            Car c= carList.get(x);
            y= c.getCarCount() ;
            if(y== 0)
                return false;
            c.setCarCount(y- 1);
            carList.set(x, c);
            return true;
        }
        else
            return false;
    }

    public void readCarsFromFile()
    {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
            while (true) {
                line = br.readLine();
                if (line == null) break;
                String [] values= line.split(",");
                Car c= new Car(values[0], Integer.parseInt(values[1]), values[2], values[3],
                        values[4], values[5], values[6], Integer.parseInt(values[7]), Integer.parseInt(values[8]));
                carList.add(c);
                //create a object of car class
                //call set methods with appropriate values
                //add to the list

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
