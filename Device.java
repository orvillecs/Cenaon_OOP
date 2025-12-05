class Device {
    private boolean isOn = false;
    public void turnOn() {
        isOn = true;
        showStatus();
    }

    public void turnOff() {
        isOn = false;
        showStatus();
    }

    public boolean isOn() {
        return isOn;
    }

    public void showStatus() {
        System.out.println("Device status: " + (isOn ? "ON" : "OFF"));
        System.out.println();
    }

    public static void powerDevices(Device[] devices, boolean powerOn) {
        for (Device d : devices) {
            if (powerOn) d.turnOn();
            else d.turnOff();
        }
    }

    public static int countDevicesOn(Device[] devices) {
        int count = 0;
        for (Device d : devices) {
            if (d.isOn()) count++;
        }
        return count;
    }
}

class AirConditioner extends Device {
    private int fanSpeed = 3;
    private int temperature = 24;

    public AirConditioner() {
      }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
        showStatus();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        showStatus();
    }

    @Override
    public void showStatus() {
        if (isOn()) {
          System.out.println("Air Conditioner is turned on.");
          System.out.println(
            " _______________________________\n" + 
            "|  __________________   ______  |\n" +
            "| I__________________I |——————| |\n" +
            "| I__________________I |——————| |\n" + 
            "| I__________________I |——————| |\n" + 
            "| I__________________I |——————| |\n" + 
            "| I__________________I I——————I |\n" + 
            "| I__________________I  ______  |\n" + 
            "| I__________________I | " + temperature + "°C | |\n" +
            "| I__________________I |______| |\n" +
            "|_______________________________|");
            System.out.println("» Fan Speed: " + fanSpeed);
            System.out.println("» Temperature: " + temperature + "°C");
        } else {
            System.out.println("Air Conditioner is turned off.");
        }
        System.out.println();
    }
}

class LampShade extends Device {
    private int brightness;
    private String lightColor;

    public LampShade() {
        this.brightness = 0;
        this.lightColor = "White";
    }

    public LampShade(int brightness, String lightColor) {
        this.brightness = brightness;
        this.lightColor = lightColor;
    }

    public LampShade(LampShade other) {
        this.brightness = other.brightness;
        this.lightColor = other.lightColor;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
        showStatus();
    }

    public void setLightColor(String lightColor) {
        this.lightColor = lightColor;
        showStatus();
    }

    @Override
    public void showStatus() {
        if (isOn()) {
            System.out.println("Lamp Shade is turned on.");
            System.out.println(
              "     .————.\n" +
              "    /  🟡  \\\n" +
              "   | 🟡💡🟡 |\n" +
              "    \\  🟡  /\n" +
              "     '————'\n" +
              "       ||\n" +
              "       ||\n" +
              "       ||\n" +
              "      _||_"
              );
              System.out.println("» Brightness: " + brightness + "%");
              System.out.println("» Light Color: " + lightColor);
        } else {
            System.out.println("Lamp Shade is turned off.");
        }
        System.out.println();
    }
}

class Television extends Device {
    private int channel;
    private int volume;

    public Television(int channel, int volume) {
        this.channel = channel;
        this.volume = volume;
    }

    public void setChannel(int channel) {
        this.channel = channel;
        showStatus();
    }

    public void setVolume(int volume) {
        this.volume = volume;
        showStatus();
    }

    @Override
    public void showStatus() {
        if (isOn()) {
            System.out.println("Television is turned on.");
            System.out.println(
              " _____________________________\n" +
              "|  _________________________  |\n" +
              "| |                         | |\n" +
              "| |  \\___________________/  | |\n" +
              "| |  __/__/_________\\__\\__  | |\n" +
              "| |  /⭕⭕\\________/⭕⭕\\   | |\n" +
              "| |  |_______🄶🅃🅁_______|  | |\n" +
              "| |   \\●●___||___||___.●●/  | |\n" +
              "| |_________________________| |\n" +
              "|_____________________________|\n" +
              "            __| |__            "
              );
              System.out.println("» Channel: " + channel);
              System.out.println("» Volume: " + volume + "%"
              );
        } else {
          System.out.println("Television is turned off.");
        }
        System.out.println();
    }
}

class Microwave extends Device {
    private int timer = 10;
    private int temperature = 71;

    public Microwave() {
      }

    public void setTimer(int timer) {
        this.timer = timer;
        showStatus();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        showStatus();
    }

    @Override
    public void showStatus() {
        if (isOn()) {
            System.out.println("Microwave is turned on.");
            System.out.println(
              " _______________________________\n" +
              "| +———————————————————+  _____  |\n" +
              "| |                   | |" + timer + ":00| |\n" +
              "| |                   | | 123 | |\n" + 
              "| |                   | | 456 | |\n" +
              "| |                   | | 789 | |\n" +
              "| |                   | |__0__| |\n" +
              "| |                   |  _____  |\n" +
              "| +———————————————————+ |_____| |\n" +
              "|_______________________________|\n"
              );
              System.out.println("» Timer: " + timer + " minutes");
              System.out.println("» Temperature: " + temperature + "°C");
        } else {
          System.out.println("Microwave is turned off.");
        }
        System.out.println();
    }
}
