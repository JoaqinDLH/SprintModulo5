package com.example.trabajom5tg1.controlador;

import com.example.trabajom5tg1.dao.CapacitacionDAOImp;
import com.example.trabajom5tg1.models.Capacitacion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class ListarCapacitacion
 */

@WebServlet(name="listarCapacitacion" , value="/listar-capacitacion")
public class ListarCapacitacion extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCapacitacion() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        HttpSession session = request.getSession();

        if ( session.getAttribute("loggedIn") == null ) {

            response.sendRedirect("iniciar-sesion");

        }else {

            /*if (session.getAttribute("listaCapacitacion") == null) {
                session.setAttribute("listaCapacitacion", new ArrayList<Capacitacion>());
            }

            Contenedor ct = new Contenedor();

            List<Capacitacion> capacitaciones = (ArrayList<Capacitacion>) session.getAttribute("listaCapacitacion");

            for (Capacitacion c : capacitaciones
            ) {
                ct.almacenarCapacitacion(c);
            }*/

            CapacitacionDAOImp capacitacionDAO = new CapacitacionDAOImp();
            PrintWriter out = response.getWriter();

            List<Capacitacion> listado = capacitacionDAO.listarCapacitaciones();
            if(!listado.isEmpty()){
                out.println("Capacitaciones listadas");
                request.setAttribute("listaCapacitacion",listado);

            }

            request.setAttribute("seccion", "capacitacion");

            getServletContext().getRequestDispatcher("/views/capacitacion_listar.jsp").forward(request, response);

        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        /*int numCapacitacion = Integer.parseInt(request.getParameter("numCapacitacion")) ;
        String rutCliente = request.getParameter("rutCliente");
        String diaSemana = request.getParameter("diaSemana");
        String hora = request.getParameter("hora");
        String lugar = request.getParameter("lugar");
        String duracion = request.getParameter("duracion");
        int cantAsistentes = Integer.parseInt(request.getParameter("cantAsistentes"));

        Capacitacion cap = new Capacitacion( numCapacitacion,  rutCliente,  diaSemana,  hora,  lugar,  duracion,  cantAsistentes );

        request.setAttribute("seccion","capacitacion" );
        request.setAttribute("respuesta", cap.mostrarDetalle() );
        RequestDispatcher rd = request.getRequestDispatcher("/views/capacitacion_crear.jsp" );
        rd.forward(request, response);*/



    }


}