package week2day5;


public class HotelTest {
    public static void main(String[] args){
        Hotel myHotel=new Hotel();
        myHotel.setName("Beach Marriot");
        myHotel.setLocation("somewhere in earth");
        myHotel.addRoom(101,"queen",'s',100.0);
        myHotel.addRoom(102,"king",'n',110.0);
        myHotel.addRoom(103,"queen",'n',88.0);
        myHotel.addRoom(104,"queen",'n',99.0);
        myHotel.addRoom(105,"twin",'s',100.0);
        myHotel.addRoom(106,"queen",'s',95.0);
        myHotel.addRoom(107,"king",'s',120.0);
        System.out.println(myHotel);

        myHotel.addReservation("amy",'n',"queen");
        myHotel.addReservation("bobby",'s',"king");
        myHotel.addReservation("coco",'n',"twin");
        myHotel.addReservation("david",'n',"queen");
        myHotel.printReservationList();

        myHotel.cancelReservation("david");
        myHotel.printReservationList();

        System.out.println("\n\nDaily sale: "+myHotel.getDailySales());
        System.out.println("Occupancy Percentage: "+ myHotel.occupancyPercentage());
    }
}
