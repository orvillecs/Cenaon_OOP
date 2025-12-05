public class  SmartHomeManagementSystem {
    public static void main(String[] args) {
      
        AirConditioner ac = new AirConditioner();

        LampShade lamp1 = new LampShade(100, "Yellow");
        
        LampShade lamp2 = new LampShade(lamp1);

        Television tv = new Television(1, 10);

        Microwave microwave = new Microwave();

        Device[] homeDevices = {ac, lamp1, lamp2, tv, microwave};
        
        System.out.println("————————————————————————————————————————");
        
        System.out.println("Turning all devices ON...");
        Device.powerDevices(homeDevices, true);
        
        System.out.println("————————————————————————————————————————");

        System.out.println("Turning all devices OFF...");
        Device.powerDevices(homeDevices, false);
        
        System.out.println("————————————————————————————————————————");

        ac.turnOn();
        tv.turnOn();

        int onCount = Device.countDevicesOn(homeDevices);
        System.out.println("Number of devices currently ON: " + onCount);
        System.out.println("————————————————————————————————————————");
    }
}