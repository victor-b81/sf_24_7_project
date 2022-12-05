/**
 * ���������� StudyProfile
 * ������������ ����� �������
 */

package enumenators;

public enum StudyProfile {
    MEDICINE ("��������"),
    IT ("��"),
    MECHANICS ("��������"),
    MANAGEMENT ("����������"),
    LINGUISTICS ("�����������"),
    MATHEMATICS ("����������"),
    PHYSICS ("������");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;     // ������� ��������� �������� �������
    }

    @Override
    public String toString() {
        return profileName;
    }
}
