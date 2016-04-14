
41A)
CREATE OR REPLACE PACKAGE college_package IS
  PROCEDURE get_instructor(p_instr_id IN NUMBER, p_rec OUT instructors%ROWTYPE);
END college_package;

41B)
CREATE OR REPLACE PACKAGE BODY college_package IS
  PROCEDURE get_instructor(
    p_instr_id  IN   NUMBER,
    p_rec OUT  instructors%ROWTYPE
) IS
  BEGIN
    SELECT * INTO p_rec FROM instructors WHERE instructor_id = p_instr_id;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
       DBMS_OUTPUT.PUT_LINE('Instructor ID ' || p_instr_id || ' is not found.');
  END;
END college_package;

41C)
DECLARE
  v_rec instructors%ROWTYPE;
BEGIN
  college_package.get_instructor(:instructor_id, v_rec);
  DBMS_OUTPUT.PUT_LINE('Id:     ' || v_rec.instructor_id);
  DBMS_OUTPUT.PUT_LINE('Name:   ' || v_rec.first_name || ' ' || v_rec.last_name);
  DBMS_OUTPUT.PUT_LINE('Phone:  ' || v_rec.work_phone);
  DBMS_OUTPUT.PUT_LINE('Email:  ' || v_rec.email);
  DBMS_OUTPUT.PUT_LINE('Office: ' || v_rec.office_location);
END;