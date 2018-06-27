<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>
<%@ page import="java.io.OutputStream"%>
<%@ page import="java.awt.Color"%>
<%@ page import="java.awt.Font"%>
<%@ page import="java.awt.Graphics"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="javax.imageio.ImageIO"%>
<%
	int width = 80;
	int height = 32;
	//create the image
	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	// set the background color
	g.setColor(new Color(0xDCDCDC));
	g.fillRect(0, 0, width, height);
	// draw the border
	g.setColor(Color.black);
	g.drawRect(0, 0, width - 1, height - 1);
	// create a random instance to generate the codes
	Random rdm = new Random();
	String hash1 = Integer.toHexString(rdm.nextInt());
	// make some confusion
	for (int i = 0; i < 50; i++) {
		int x = rdm.nextInt(width);
		int y = rdm.nextInt(height);
		g.drawOval(x, y, 0, 0);
	}
	// generate a random code
	String capstr = hash1.substring(0, 4);
	session.setAttribute("key", capstr);
	g.setColor(new Color(0, 100, 0));
	g.setFont(new Font("Candara", Font.BOLD, 24));
	g.drawString(capstr, 8, 24);
	g.dispose();
	response.setContentType("image/jpeg");
	out.clear();
	out = pageContext.pushBody();
	OutputStream strm = response.getOutputStream();
	ImageIO.write(image, "jpeg", strm);
	strm.close();
	%>

<%-- <%@page import="org.patchca.font.RandomFontFactory"%>
<%@page import="org.patchca.font.FontFactory"%>
<%@ page contentType="image/jpeg"
import="java.util.*,java.awt.*,java.io.*,java.awt.image.*,javax.imageio.*,org.patchca.color.ColorFactory,
org.patchca.color.SingleColorFactory,org.patchca.filter.predefined.CurvesRippleFilterFactory,org.patchca.filter.predefined.DiffuseRippleFilterFactory,
org.patchca.filter.predefined.DoubleRippleFilterFactory,org.patchca.filter.predefined.MarbleRippleFilterFactory,org.patchca.filter.predefined.WobbleRippleFilterFactory,
org.patchca.service.ConfigurableCaptchaService,org.patchca.utils.encoder.EncoderHelper,org.patchca.word.RandomWordFactory"
pageEncoding="utf-8"%>
<%!
	private static ConfigurableCaptchaService cs = null;
	private static ColorFactory cf = null;
	private static FontFactory ff = null;
	private static RandomWordFactory wf = null;
	private static CurvesRippleFilterFactory crff = null;
	private static Random r = new Random();
	private static MarbleRippleFilterFactory mrff = null;
	private static DoubleRippleFilterFactory drff = null;
	private static WobbleRippleFilterFactory wrff = null;
	private static DiffuseRippleFilterFactory dirff = null;
%>
<%
try {
response.setContentType("image/png");
response.setHeader("cache", "no-cache");
cs = new ConfigurableCaptchaService();
cf = new SingleColorFactory(new Color(25, 60, 170));
/* ff = new RandomFontFactory(new ArrayList().add("Courier New")); */
wf = new RandomWordFactory();
crff = new CurvesRippleFilterFactory(cs.getColorFactory());
drff = new DoubleRippleFilterFactory();
wrff = new WobbleRippleFilterFactory();
dirff = new DiffuseRippleFilterFactory();
mrff = new MarbleRippleFilterFactory();
cs.setWordFactory(wf);
cs.setColorFactory(cf);
cs.setFontFactory(ff);
wf.setMaxLength(5);
wf.setMinLength(3);
wf.setCharacters("ABCDEFTGHIJLMNPQRSTUVWXZabcdefghijklmnopqrstuvwxyz");
switch (r.nextInt(5)) {
case 0:
cs.setFilterFactory(crff);
break;
case 1:
cs.setFilterFactory(mrff);
break;
case 2:
cs.setFilterFactory(drff);
break;
case 3:
cs.setFilterFactory(wrff);
break;
case 4:
cs.setFilterFactory(dirff);
break;
}
response.reset();   
OutputStream output = response.getOutputStream();
String captcha = EncoderHelper.getChallangeAndWriteImage(cs, "png",output);
// 将认证码存入SESSION
session.setAttribute("rand", captcha);
// 输出图象到页面
output.flush();
out.clear();
out = pageContext.pushBody();
} catch (Exception e) {
e.printStackTrace();
}
%> --%>

<%-- <%@page import="org.patchca.background.BackgroundFactory"%>
<%@ page contentType="image/jpeg"
	import="java.util.*,java.awt.*,java.io.*,java.awt.image.*,javax.imageio.*,org.patchca.color.ColorFactory,org.patchca.background.SingleColorBackgroundFactory,
	org.patchca.color.SingleColorFactory,org.patchca.filter.predefined.CurvesRippleFilterFactory,org.patchca.filter.predefined.DiffuseRippleFilterFactory,
	org.patchca.filter.predefined.DoubleRippleFilterFactory,org.patchca.filter.predefined.MarbleRippleFilterFactory,org.patchca.filter.predefined.WobbleRippleFilterFactory,
	org.patchca.service.ConfigurableCaptchaService,org.patchca.utils.encoder.EncoderHelper,org.patchca.word.RandomWordFactory"
	pageEncoding="utf-8"%>
<%!
	private static ConfigurableCaptchaService cs = null;
	private static ColorFactory cf = null;
	private static RandomWordFactory wf = null;
	private static CurvesRippleFilterFactory crff = null;
	private static Random r = new Random();
	private static MarbleRippleFilterFactory mrff = null;
	private static DoubleRippleFilterFactory drff = null;
	private static WobbleRippleFilterFactory wrff = null;
	private static DiffuseRippleFilterFactory dirff = null;
	//private static BackgroundFactory bf=null;
%>
<%
	try {
		response.setContentType("image/png");
		response.setHeader("cache", "no-cache");
		cs = new ConfigurableCaptchaService();
		cf = new SingleColorFactory(new Color(25, 60, 170));
		//bf=new SingleColorBackgroundFactory(new Color(252,255,242));
		wf = new RandomWordFactory();
		crff = new CurvesRippleFilterFactory(cs.getColorFactory());
		drff = new DoubleRippleFilterFactory();
		wrff = new WobbleRippleFilterFactory();
		dirff = new DiffuseRippleFilterFactory();
		mrff = new MarbleRippleFilterFactory();
		cs.setWordFactory(wf);
		cs.setColorFactory(cf);
		//cs.setBackgroundFactory(bf);
		wf.setMaxLength(5);
		wf.setMinLength(3);
		switch (r.nextInt(5)) {
		case 0:
			cs.setFilterFactory(crff);
			break;
		case 1:
			cs.setFilterFactory(mrff);
			break;
		case 2:
			cs.setFilterFactory(drff);
			break;
		case 3:
			cs.setFilterFactory(wrff);
			break;
		case 4:
			cs.setFilterFactory(dirff);
			break;
		}
		OutputStream output = response.getOutputStream();
		String captcha = EncoderHelper.getChallangeAndWriteImage(cs, "png",
				output);
				
		// 将认证码存入SESSION
		session.setAttribute("login_code", captcha);
		// 输出图象到页面
		output.flush();
		out.clear();
		out = pageContext.pushBody();
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
 --%>