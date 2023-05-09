package marketapp.marketapp;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.*;

public class Tableicon extends JPanel{
    Object[][] contents;
    public JTable table;
    public Tableicon() {
        ImageIcon homerunball = new ImageIcon(new ImageIcon("src\\main\\java\\image\\homerunball.jpg").getImage()
                .getScaledInstance(150, 120, Image.SCALE_SMOOTH));
        //ImageIcon homerunball = new ImageIcon("src\\main\\java\\img\\homerunball.jpg");
        ImageIcon mask = new ImageIcon(new ImageIcon("src\\main\\java\\image\\mask.png").getImage()
                .getScaledInstance(150, 120, Image.SCALE_SMOOTH));

        //상품 테이블
        String[] header = {"상품 이미지", "상품명", "상품 설명", "가격"};
        contents = new Object[][]{
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
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };

        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.addMouseListener(new TableMouse());
        table.setRowHeight(100);
        //table.setSize(1440, 960);
        //table.setPreferredScrollableViewportSize(table.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1440, 960));

        add(scrollPane);

    }

}
