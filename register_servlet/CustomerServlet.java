package register_servlet;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;

    public void init() {
    	customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    System.out.println(request.getParameter("name"));
    	int registerCustomerId = 0;
    	
        String name = request.getParameter("name");
        
        String email = request.getParameter("email");
        String confirmEmail = request.getParameter("confirmEmail");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        Customer customer = new Customer();
        customer.setName(name);
        
        customer.setEmail(email);
        customer.setConfirmEmail(confirmEmail);
        customer.setPassword(password);
        customer.setConfirmPassword(confirmPassword);
        

        try {
        	registerCustomerId = customerDAO.registerCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(registerCustomerId > 0) {
        request.setAttribute("name",customer.getName());
          request.setAttribute("email",customer.getEmail());
          request.setAttribute("confirmEmail",customer.getConfirmEmail());
          request.setAttribute("password", customer.getPassword());
          request.setAttribute("confirmPassword", customer.getConfirmPassword());

          RequestDispatcher requestDispatcher = request.getRequestDispatcher("customerDetails.jsp");
          requestDispatcher.forward(request, response);
        }
    }
}