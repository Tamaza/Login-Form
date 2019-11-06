package LoginForm.model.enums;


public enum Gender {

    FEMALE {
                @Override
                public String toString() {
                    return "Female";
                }
            },
    MALE {
                @Override
                public String toString() {
                    return "Male";
                }
            }

}
