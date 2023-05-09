package notuse;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class Tableicon extends JPanel {

    public Tableicon() {
        ImageIcon homerunball = new ImageIcon(new ImageIcon("src\\main\\java\\img\\homerunball.jpg").getImage()
                .getScaledInstance(150, 120, Image.SCALE_SMOOTH));
        //ImageIcon homerunball = new ImageIcon("src\\main\\java\\img\\homerunball.jpg");
        ImageIcon mask = new ImageIcon(new ImageIcon("src\\main\\java\\img\\mask.png").getImage()
                .getScaledInstance(150, 120, Image.SCALE_SMOOTH));

        //상품 테이블
        String[] header = {"상품 이미지", "상품명", "상품 설명", "가격"};
        Object[][] contents = new Object[][]{
            {homerunball, "홈런볼", "존맛탱", "1조"},
            {mask, "락스", "뽀득뽀득굳", "공짜"},
            {"이미지", "짱구마우스", "귀여웡", "300원"},
            {"이미지", "마스크", "미세먼지 저리가", "5원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},
            {"이미지", "시계", "째깍째깍", "1원"},};

        DefaultTableModel model = new DefaultTableModel(contents, header) {
            public boolean isCellEditable(int i, int c) {
                return false;
            }

            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        JTable table = new JTable(model);
        table.setRowHeight(100);
        table.setSize(1440, 960);

        //table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

}
