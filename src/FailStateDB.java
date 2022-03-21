public static void main(String[] args)
        {
        String states[][] = new String[51][5];

        fillAray(states);
        print(states);

        }

public static String[][] fillAray(String states[][])
        {
        try {
        Scanner inFile = new Scanner(new File("data/states.txt"));

        while (inFile.hasNext())
        {
        for (int r = 0; r < 51; r++)
        {
        for (int c = 0; c < 5; c++)
        {
        states[r][c] = inFile.nextLine();
        }
        }
        }
        inFile.close();
        } catch (Exception e) {
        e.printStackTrace();
        }
        return states;
        }

public static void print(String[][] states)
        {
        JTextArea area = new JTextArea();
        //append column headings here
        int spaces[] = new int[]{22, 18, 30, 30};

        String name = "NAME", capital = "CAPITAL", flower = "FLOWER", bird = "BIRD", pop = "POPULATION";

        while(name.length() <= spaces[0])
        name += " ";
        while(capital.length() <= spaces[1])
        capital += " ";
        while(flower.length() <= spaces[2])
        flower += " ";
        while(bird.length() <= spaces[3])
        bird += " ";

        area.append(name+capital+flower+bird+pop+"\n\n");

        for (int i=0; i<states.length; i++) {
        name = states[i][0];
        capital = states[i][1];
        flower = states[i][2];
        bird = states[i][3];
        pop = states[i][4];

        while(name.length() <= spaces[0])
        name += " ";
        while(capital.length() <= spaces[1])
        capital += " ";
        while(flower.length() <= spaces[2])
        flower += " ";
        while(bird.length() <= spaces[3])
        bird += " ";

        area.append(name+capital+flower+bird+pop+"\n");
        }

        area.setBackground(new Color(255,250,205));
        area.setForeground(new Color(0,0,0));
        area.setFont(new Font("Andale Mono", Font.PLAIN, 15));
        // how many rows will show at one time
        area.setRows(35);
        // how many columns (1 char) will show at one time
        area.setColumns(115);
        JScrollPane pane = new JScrollPane(area);
        JOptionPane.showMessageDialog(null,pane);
        }