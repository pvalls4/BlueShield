<%@ include file="../header.jsp" %>
<div class="container border border-dark rounded" style="background-color: #9acbfd">
    <div class="row  mb-3 px-4">
        <table class="table">
            <tbody>
                <tr>
                    <td class="col d-flex justify-content-center" colspan="3">El veh&iacute;culo declarado no consta de registro en la base de datos</td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="row  mb-3">
        <a href="nuevaMulta" class="col d-flex justify-content-center"><button type="submit" class="btn btn-primary b-login ms-4 mb-2">Volver al men&uacute; de nueva multa</button></a>
        <a href="dashboard" class="col d-flex justify-content-center"><button type="submit" class="btn btn-primary b-login me-4 mb-2">Volver al men&uacute; principal</button></a>
    </div>
</div>
<%@ include file="../footer.jsp" %>
