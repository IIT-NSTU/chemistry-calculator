package ChemistryCalculator.backend;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;


//execute this class if database/database.ser is corrupted or want to change/add new atoms. this will create a new one.
public class DatabaseSerializer {
    public static void main(String[] args) throws IOException {

        HashMap<String, String[]> hashMap = new HashMap<>();
        hashMap.put("H", new String[]{"1", "Hydrogen", "1.00794"});
        hashMap.put("He", new String[]{"2", "Helium", "4.002602"});
        hashMap.put("Li", new String[]{"3", "Lithium", "6.941"});
        hashMap.put("Be", new String[]{"4", "Beryllium", "9.012182"});
        hashMap.put("B", new String[]{"5", "Boron", "10.811"});
        hashMap.put("C", new String[]{"6", "Carbon", "12.0107"});
        hashMap.put("N", new String[]{"7", "Nitrogen", "14.0067"});
        hashMap.put("O", new String[]{"8", "Oxygen", "15.9994"});
        hashMap.put("F", new String[]{"9", "Fluorine", "18.9984032"});
        hashMap.put("Ne", new String[]{"10", "Neon", "20.1797"});
        hashMap.put("Na", new String[]{"11", "Sodium", "22.989769"});

        hashMap.put("Mg", new String[]{"12", "Magnesium", "24.305"});
        hashMap.put("Al", new String[]{"13", "Aluminium", "26.981538"});
        hashMap.put("Si", new String[]{"14", "Silicon", "28.0855"});
        hashMap.put("P", new String[]{"15", "Phosphorus", "30.973762"});
        hashMap.put("S", new String[]{"16", "Sulphur", "32.065"});
        hashMap.put("Cl", new String[]{"17", "Chlorine", "35.453"});
        hashMap.put("Ar", new String[]{"18", "Argon", "39.948"});
        hashMap.put("K", new String[]{"19", "Potassium", "39.0983"});
        hashMap.put("Ca", new String[]{"20", "Calcium", "40.078"});
        hashMap.put("Sc", new String[]{"21", "Scandium", "44.955912"});

        hashMap.put("Ti", new String[]{"22", "Titanium", "47.867"});
        hashMap.put("V", new String[]{"23", "Vanadium", "50.9415"});
        hashMap.put("Cr", new String[]{"24", "Chromium", "51.9961"});
        hashMap.put("Mn", new String[]{"25", "Manganese", "54.938049"});
        hashMap.put("Fe", new String[]{"26", "Iron", "55.845"});
        hashMap.put("Co", new String[]{"27", "Cobalt", "58.9332"});
        hashMap.put("Ni", new String[]{"28", "Nickel", "58.6934"});
        hashMap.put("Cu", new String[]{"29", "Copper", "63.546"});
        hashMap.put("Zn", new String[]{"30", "Zinc", "65.409"});
        hashMap.put("Ga", new String[]{"31", "Gallium", "69.723"});

        hashMap.put("Ge", new String[]{"32", "Germanium", "72.64"});
        hashMap.put("As", new String[]{"33", "Arsenic", "74.9216"});
        hashMap.put("Se", new String[]{"34", "Selenium", "78.96"});
        hashMap.put("Br", new String[]{"35", "Bromine", "79.904"});
        hashMap.put("Kr", new String[]{"36", "Krypton", "83.798"});
        hashMap.put("Rb", new String[]{"37", "Rubidium", "85.4678"});
        hashMap.put("Sr", new String[]{"38", "Strontium", "87.62"});
        hashMap.put("Y", new String[]{"39", "Yttrium", "88.90585"});
        hashMap.put("Zr", new String[]{"40", "Zirconium", "91.224"});
        hashMap.put("Nb", new String[]{"41", "Niobium", "92.90638"});

        hashMap.put("Mo", new String[]{"42", "Molybdenum", "95.94"});
        hashMap.put("Tc", new String[]{"43", "Technetium", "97.9072"});
        hashMap.put("Ru", new String[]{"44", "Ruthenium", "101.07"});
        hashMap.put("Rh", new String[]{"45", "Rhodium", "102.9055"});
        hashMap.put("Pd", new String[]{"46", "Palladium", "106.42"});
        hashMap.put("Ag", new String[]{"47", "Silver", "107.8682"});
        hashMap.put("Cd", new String[]{"48", "Cadmium", "112.411"});
        hashMap.put("In", new String[]{"49", "Indium", "114.818"});
        hashMap.put("Sn", new String[]{"50", "Tin", "118.71"});
        hashMap.put("Sb", new String[]{"51", "Antimony", "121.76"});

        hashMap.put("Te", new String[]{"52", "Tellurium", "127.6"});
        hashMap.put("I", new String[]{"53", "Iodine", "126.90447"});
        hashMap.put("Xe", new String[]{"54", "Xenon", "131.293"});
        hashMap.put("Cs", new String[]{"55", "Caesium", "132.90545"});
        hashMap.put("Ba", new String[]{"56", "Barium", "137.327"});
        hashMap.put("La", new String[]{"57", "Lanthanum", "138.9055"});
        hashMap.put("Ce", new String[]{"58", "Cerium", "140.116"});
        hashMap.put("Pr", new String[]{"59", "Praseodymium", "140.90765"});
        hashMap.put("Nd", new String[]{"60", "Neodymium", "144.24"});
        hashMap.put("Pm", new String[]{"61", "Promethium", "144.9127"});

        hashMap.put("Sm", new String[]{"62", "Samarium", "150.36"});
        hashMap.put("Eu", new String[]{"63", "Europium", "151.964"});
        hashMap.put("Gd", new String[]{"64", "Gadolinium", "157.25"});
        hashMap.put("Tb", new String[]{"65", "Terbium", "158.92534"});
        hashMap.put("Dy", new String[]{"66", "Dysprosium", "162.5"});
        hashMap.put("Ho", new String[]{"67", "Holmium", "164.93032"});
        hashMap.put("Er", new String[]{"68", "Erbium", "167.259"});
        hashMap.put("Tm", new String[]{"69", "Thulium", "168.93421"});
        hashMap.put("Yb", new String[]{"70", "Ytterbium", "173.04"});
        hashMap.put("Lu", new String[]{"71", "Lutetium", "174.967"});

        hashMap.put("Hf", new String[]{"72", "Hafnium", "178.49"});
        hashMap.put("Ta", new String[]{"73", "Tantalum", "180.9479"});
        hashMap.put("W", new String[]{"74", "Tungsten", "183.84"});
        hashMap.put("Re", new String[]{"75", "Rhenium", "186.207"});
        hashMap.put("Os", new String[]{"76", "Osmium", "190.23"});
        hashMap.put("Ir", new String[]{"77", "Iridium", "192.217"});
        hashMap.put("Pt", new String[]{"78", "Platinum", "195.078"});
        hashMap.put("Au", new String[]{"79", "Gold", "196.96655"});
        hashMap.put("Hg", new String[]{"80", "Mercury", "200.59"});
        hashMap.put("Tl", new String[]{"81", "Thallium", "204.3833"});

        hashMap.put("Pb", new String[]{"82", "Lead", "207.2"});
        hashMap.put("Bi", new String[]{"83", "Bismuth", "208.98038"});
        hashMap.put("Po", new String[]{"84", "Polonium", "208.9824"});
        hashMap.put("At", new String[]{"85", "Astatine", "209.9871"});
        hashMap.put("Rn", new String[]{"86", "Radon", "222.0176"});
        hashMap.put("Fr", new String[]{"87", "Francium", "223.0197"});
        hashMap.put("Ra", new String[]{"88", "Radium", "226.0254"});
        hashMap.put("Ac", new String[]{"89", "Actinium", "227.0277"});
        hashMap.put("Th", new String[]{"90", "Thorium", "232.03806"});
        hashMap.put("Pa", new String[]{"91", "Protactinium", "231.03588"});

        hashMap.put("U", new String[]{"92", "Uranium", "238.02891"});
        hashMap.put("Np", new String[]{"93", "Neptunium", "237.0482"});
        hashMap.put("Pu", new String[]{"94", "Plutonium", "244.0642"});
        hashMap.put("Am", new String[]{"95", "Americium", "243.0614"});
        hashMap.put("Cm", new String[]{"96", "Curium", "247.0704"});
        hashMap.put("Bk", new String[]{"97", "Berkelium", "247.0703"});
        hashMap.put("Cf", new String[]{"98", "Californium", "251.0796"});
        hashMap.put("Es", new String[]{"99", "Einsteinium", "252.0830"});
        hashMap.put("Fm", new String[]{"100", "Fermium", "257.0951"});
        hashMap.put("Md", new String[]{"101", "Mendelevium", "258.0984"});

        hashMap.put("No", new String[]{"102", "Nobelium", "259.1010"});
        hashMap.put("Lr", new String[]{"103", "Lawrencium", "262.1097"});
        hashMap.put("Rf", new String[]{"105", "Rutherfordium", "261.1088"});
        hashMap.put("Db", new String[]{"105", "Dubnium", "262.1141"});
        hashMap.put("Sg", new String[]{"106", "Seaborgium", "266.1219"});
        hashMap.put("Bh", new String[]{"107", "Bohrium", "264.12"});
        hashMap.put("Hs", new String[]{"108", "Hassium", "277.0"});
        hashMap.put("Mt", new String[]{"109", "Meitnerium", "268.1388"});
        hashMap.put("Ds", new String[]{"110", "Darmstadtium", "271.0"});
        hashMap.put("Rg", new String[]{"111", "Roentgenium", "272.0"});

        hashMap.put("Cn", new String[]{"112", "Copernicium", "285.0"});
        hashMap.put("Nh", new String[]{"113", "Nihonium", "284.0"});
        hashMap.put("Fi", new String[]{"114", "Flerovium", "285.0"});
        hashMap.put("Mc", new String[]{"115", "Moscovium", "288.0"});
        hashMap.put("Lv", new String[]{"116", "Livermorium", "292.0"});
        hashMap.put("Ts", new String[]{"117", "Tennessine", "294.211"});
        hashMap.put("Og", new String[]{"118", "Oganesson", "294.0"});


        //this path will vary for project location.
        FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/HP/Desktop/ChemCal/src/ChemistryCalculator/database/databases.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(hashMap);


//########## printing all element from database.ser##############
//        FileInputStream fileInputStream = new FileInputStream("atom.ser");
//        ObjectInputStream objectinputStream = new ObjectInputStream(fileInputStream);
//        HashMap<String, String[]> out = (HashMap<String, String[]>) objectinputStream.readObject();
//
//        out.forEach((k, v)-> System.out.println(k + Arrays.toString(v)));
    }

}
