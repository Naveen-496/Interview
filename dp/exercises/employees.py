

class Employee:
  emp_count = 0
  
  def __init__(self, name) -> None:
    self.name = name
    Employee.emp_count += 1
    
  def get_name(self):
    return self.name  
  
  @classmethod
  def get_count(cls):
    return cls.emp_count
  
  @staticmethod
  def get_firstname_to_lowercase(self, name: str):
    return name.lower()

emp = Employee("Suresh")
print(emp.get_count())
print(emp.get_name())
print(Employee.get_count())
print(emp.get_firstname_to_lowercase(emp, emp.get_name()))
