import java.awt.Color;
import java.util.Random;

public class DrawSolar {
    public static void main(String[] args) {
        Random rand = new Random();
        ShapeDrawer solar = new ShapeDrawer(2000, 2000);
        ShapeUtils shape = new ShapeUtils();


        double centerX = solar.getMaxX() / 2;
        double centerY = solar.getMaxY() / 2;
        double sunRad = 100;

        // Orbit rings
        Ring mercuryRing = new Ring(new Circle(new Point(centerX, centerY), sunRad + 25), 1);
        Ring venusRing = new Ring(new Circle(new Point(centerX, centerY), sunRad + 50), 1);
        Ring earthRing = new Ring(new Circle(new Point(centerX, centerY), sunRad + 100), 1);
        Ring marsRing = new Ring(new Circle(new Point(centerX, centerY), sunRad + 140), 1);
        Ring asteroidBelt = new Ring(new Circle(new Point(centerX, centerY), sunRad + 250), 50);
        Ring jupiterRing = new Ring(new Circle(new Point(centerX, centerY), sunRad + 350), 1);
        Ring saturnRing = new Ring(new Circle(new Point(centerX, centerY), sunRad + 500), 1);
        Ring uranusRing = new Ring(new Circle(new Point(centerX, centerY), sunRad + 600), 1);
        Ring neptuneRing = new Ring(new Circle(new Point(centerX, centerY), sunRad + 700), 1);
        Ring plutoRing = new Ring(new Circle(new Point(centerX, centerY), sunRad + 800), 1);

        // Planet/Sun circles 
        Circle sun = new Circle(new Point(centerX, centerY), sunRad);
        Circle mercury = new Circle(shape.randRingCoord(mercuryRing), 3);
        Circle venus = new Circle(shape.randRingCoord(venusRing), 8);
        Circle earth = new Circle(shape.randRingCoord(earthRing), 10);
        Circle mars = new Circle(shape.randRingCoord(marsRing), 5);
        Circle jupiter = new Circle(shape.randRingCoord(jupiterRing), 50);
        Circle saturn = new Circle(shape.randRingCoord(saturnRing), 45);
        Circle uranus = new Circle(shape.randRingCoord(uranusRing), 35);
        Circle neptune = new Circle(shape.randRingCoord(neptuneRing), 30);
        Circle pluto = new Circle(shape.randRingCoord(plutoRing), 2);

        // Moon rings
        Ring moonRing = new Ring(new Circle(new Point(earth.getCenter().getX(), earth.getCenter().getY()), 17), 1);
        Ring jupMoonRing = new Ring(new Circle(new Point(jupiter.getCenter().getX(), jupiter.getCenter().getY()), 60), 1);
        Ring satMoonRing = new Ring(new Circle(new Point(saturn.getCenter().getX(), saturn.getCenter().getY()), 55), 1);
        Ring nepMoonRing = new Ring(new Circle(new Point(neptune.getCenter().getX(), neptune.getCenter().getY()), 40), 1);

        // Moon circles
        Circle moon = new Circle(shape.randRingCoord(moonRing), 1.5);
        Circle io = new Circle(shape.randRingCoord(jupMoonRing), 1.8);
        Circle europa = new Circle(shape.randRingCoord(jupMoonRing), 1.5);
        Circle ganymede = new Circle(shape.randRingCoord(jupMoonRing), 2.5);
        Circle callisto = new Circle(shape.randRingCoord(jupMoonRing), 2);
        Circle titan = new Circle(shape.randRingCoord(satMoonRing), 1.9);
        Circle titron = new Circle(shape.randRingCoord(nepMoonRing), 1.4);
        
        // draw the stars
        solar.setStroke(new Color(255, 255, 255));
        for (int i = 0; i < solar.getMaxX() / 4; i++) {
            int intX = (int)solar.getMaxX();
            int intY = (int)solar.getMaxY();
            double randX = (double)rand.nextInt(intX);
            double randY = (double)rand.nextInt(intY);

            Point star = new Point(randX, randY);
            solar.draw(star);
        }
        // draw orbital rings
        solar.setStroke(new Color(200, 200, 200));
        solar.draw(mercuryRing);
        solar.draw(venusRing);
        solar.draw(earthRing);
        solar.draw(marsRing);
        solar.draw(jupiterRing);
        solar.draw(saturnRing);
        solar.draw(uranusRing);
        solar.draw(neptuneRing);
        solar.draw(plutoRing);
        solar.draw(moonRing);
        solar.draw(jupMoonRing);
        solar.draw(satMoonRing);
        solar.draw(nepMoonRing);

        // draw asteroid belt
        solar.setStroke(new Color(173, 133, 104));
        for (int i = 0; i < 500; i++) {
            solar.draw(shape.randRingCoord(asteroidBelt));
        }

        // draw the sun
        solar.setStroke(new Color(245, 222, 47));
        solar.setFill(new Color(245, 222, 47));
        solar.draw(sun);
        
        // draw mercury
        solar.setStroke(new Color(133, 133, 133));
        solar.setFill(new Color(133, 133, 133));
        solar.draw(mercury);

        // draw venus
        solar.setStroke(new Color(255, 217, 173));
        solar.setFill(new Color(255, 217, 173));
        solar.draw(venus);

        // draw earth
        solar.setStroke(new Color(85, 129, 237));
        solar.setFill(new Color(85, 129, 237));
        solar.draw(earth);

        // draw mars
        solar.setStroke(new Color(222, 109, 71));
        solar.setFill(new Color(222, 109, 71));
        solar.draw(mars);

        // draw jupiter
        solar.setStroke(new Color(188, 143, 102));
        solar.setFill(new Color(188, 143, 102));
        solar.draw(jupiter);

        // draw saturn
        solar.setStroke(new Color(250, 217, 147));
        solar.setFill(new Color(250, 217, 147));
        solar.draw(saturn);

        // draw uranus
        solar.setStroke(new Color(100, 210, 227));
        solar.setFill(new Color(100, 210, 227));
        solar.draw(uranus);

        // draw neptune
        solar.setStroke(new Color(64, 93, 222));
        solar.setFill(new Color(64, 93, 222));
        solar.draw(neptune);

        // draw pluto
        solar.setStroke(new Color(223, 215, 204));
        solar.setFill(new Color(223, 215, 204));
        solar.draw(pluto);

        // draw moons
        solar.setStroke(new Color(207, 199, 212));
        solar.setFill(new Color(207, 199, 212));
        solar.draw(moon);
        solar.draw(io);
        solar.draw(europa);
        solar.draw(ganymede);
        solar.draw(callisto);
        solar.draw(titan);
        solar.draw(titron);

        solar.writeToFile("solar.png");
    }
}
