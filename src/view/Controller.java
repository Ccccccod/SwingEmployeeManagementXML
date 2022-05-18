/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Employee;
import entity.Employees;
import java.io.File;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author MR TU
 */
public class Controller {

    private final JFrame frame;
    private List<Employee> employees;
    private final File file;
    private final JAXBContext context;

    public Controller(JFrame frame, File file) throws JAXBException {
        this.frame = frame;
        this.file = file;
        context = JAXBContext.newInstance(Employees.class);
        this.employees = readFromXML();
    }

    private List<Employee> readFromXML() throws JAXBException {
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return ((Employees) unmarshaller.unmarshal(file)).getEmployees();
    }

    private void writeToXML() throws JAXBException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(new Employees(employees), file);
    }

    public boolean add(Employee employee) throws JAXBException {
        boolean result = employees.add(employee);
        writeToXML();
        return result;
    }

    public void update(Employee employee) throws JAXBException {
        for (int i = 0; i < employees.size(); i++) {
            Employee get = employees.get(i);
            if (get.getId().equals(employee.getId())) {

            }
        }
        employees = employees.stream()
                .map(e -> e.getId().equals(employee.getId())? employee : e)
                .collect(Collectors.toList());
        writeToXML();
    }

    public boolean delete(String id) throws JAXBException {
        boolean result =  employees.removeIf(e -> e.getId().equals(id));
        writeToXML();
        return result;
    }
    
    public List<Employee> show() {
        return this.employees;
    }

    public List<Employee> search(Employee employee) {
        return employees.stream()
                .filter(e -> e.getId().contains(employee.getId()))
                .filter(e -> e.getName().contains(employee.getName()))
                .filter(e -> e.getDob().contains(employee.getDob()))
                .filter(e -> e.getAddress().contains(employee.getAddress()))
                .filter(e -> e.getEmail().contains(employee.getEmail()))
                .filter(e -> e.getPhone().contains(employee.getPhone()))
                .filter(e -> e.getPlaceOfWork().contains(employee.getPlaceOfWork()))
                .collect(Collectors.toList());
    }
}
