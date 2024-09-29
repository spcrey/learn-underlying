package designPattern;

public class ModelViewController {
    public static void main(String[] args) {
        StudentModel model = new StudentModel("ZhangSan", "Boy");
        StudentView view = new StudentView();
        StudentController studentController = new StudentController(model, view);
        studentController.updateView();
        studentController.setStudentName("LiSi");
        studentController.updateView();
    }

    static class StudentModel {
        private String name;
        private String sex;
        public StudentModel(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setSex(String sex) {
            this.sex = sex;
        }
        public String getSex() {
            return sex;
        }
    }

    static class StudentView {
        public void show(String name, String sex) {
            System.out.println("name: " + name);
            System.out.println("sex: " + sex);
        }
    }

    static class StudentController {
        private final StudentModel model;
        private final StudentView view;

        public StudentController(StudentModel model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }
        public String getStudentName() {
            return model.getName();
        }
        public void setStudentSex(String sex) {
            model.setSex(sex);
        }
        public String getStudentSex() {
            return model.getSex();
        }

        public void updateView() {
            view.show(getStudentName(), getStudentSex());
        }
    }
}
