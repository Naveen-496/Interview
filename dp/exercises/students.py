from typing import List


class Student:
    def __init__(self, name: str, age: int, subject_marks={}) -> None:
        self.name = name
        self.age = age
        self.subject_marks = subject_marks

    def add_subject_marks(self, subject, marks):
        self.subject_marks[subject] = marks


class StudentManager:
    def __init__(self) -> None:
        self.students: List[Student] = []

    def add_student(self, student: Student):
        self.students.append(student)
        return self.students

    def remove_student(self, name: str):
        students = self.students
        for i in range(len(students)):
            if students[i].name == name:
                students.remove(i)
                return
        print(f"Student {name} not found")      
    def show_students(self):
      for student in self.students:
        print(f"Name: {student.name} Age: {student.age} Marks: {student.subject_marks}")
        


def main():
    sm = StudentManager()
    while True:
      query = input("1.Add Student\n2.Show Students\n3.Remove Student\n4.Exit\n")
      if query == "4" or query == "exit":
        break
      
      elif query == "1":
        name = input("Enter name: ")
        age = input("Enter age: ")
        subject = input("Enter subject: ")
        marks = input("Enter marks: ")
        student = Student(name=name, age=age, subject_marks={subject: marks})
        print(sm.add_student(student))
        
      elif query == "2":
        sm.show_students()
      
      elif query == "3":
        name = input("Enter name to remove: ")
        sm.remove_student(name)  
        
main()        