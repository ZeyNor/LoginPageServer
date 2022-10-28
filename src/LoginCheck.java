
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javax.servlet.http.*;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginCheck() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=true", "root", "19061996");

			String queryselect = "select *from test";

			if (!request.getParameter("registerUname").equalsIgnoreCase("null")
					&& !request.getParameter("registerPassword").equalsIgnoreCase("null")) {
				System.out.println(
						"if  " + request.getParameter("registerUname") + request.getParameter("registerPassword"));

				String queryinsert = "insert into test(username,password) values(?,?)";
				PreparedStatement preparedst = (PreparedStatement) con.prepareStatement(queryinsert);
				preparedst.setString(1, request.getParameter("registerUname"));
				preparedst.setString(2, request.getParameter("registerPassword"));
				preparedst.executeUpdate();
				preparedst.close();
			}

			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(queryselect);

			boolean cheak = false;

			while (rs.next()) {
				String username = rs.getString("username");
				String pass = rs.getString("password");

				if (uname.equals(username) && password.equals(pass)) {

					cheak = true;
					HttpSession session = request.getSession();
					session.setAttribute("uname", uname);

					session.setAttribute("uname", uname);
					response.sendRedirect("member.jsp");
					break;

				}
			}

			if (!cheak) {
				response.sendRedirect("error.jsp");
			}

			st.close();
			con.close();
		} catch (Exception ex) {
			// handle the error
		}
	}
}
