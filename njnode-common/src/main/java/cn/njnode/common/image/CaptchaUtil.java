package cn.njnode.common.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 功能描述：验证码生成工具，生成完毕以后，放入servlet的session中
 * @author admin
 *
 */
public class CaptchaUtil {

	private static final int WIDTH = 100;//设置验证码图片宽度
    private static final int HEIGHT = 41;//设置验证码图片高度
    private static final int LENGTH = 4;//设置验证码长度
    
    //设置验证码随机出现的字符
    private static final String str = "1234567890" +
            "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static char[] chars = str.toCharArray();//将字符放在数组中方便随机读取
    private static Random random = new Random();

    public static void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	// 设置输出类型位图片
    	response.setContentType("image/jpeg");
    	
    	// 设置不进行缓存
    	response.setHeader("pragma", "no-cache");
    	response.setHeader("cache-control", "no-cache");
    	response.setHeader("expires", "0");
    	
    	BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
    	
    	// 创建画笔
    	Graphics graphics = image.getGraphics();
    	
    	// 设置背景颜射并绘制矩形背景
    	graphics.setColor(Color.WHITE);
    	graphics.fillRect(0, 0, WIDTH, HEIGHT);
    	
    	// 用于记录生成的验证码
    	String code = "";
    	
    	// 生成验证码，并且绘制
    	for (int i = 0; i < LENGTH; i++) {
			String temp = "" + chars[random.nextInt(str.length())];
			graphics.setColor(getRandomColor());
			graphics.setFont(new Font("Arial", Font.BOLD, 30));
			code += temp;
		}
    	myDrawString(code, 10, 35, 0.90d, graphics);
    	// 生成干扰点
    	for(int i = 0 ; i < 50 ; i++){
    		graphics.setColor(getRandomColor());
    		graphics.drawOval(random.nextInt(100), random.nextInt(40), 1, 1);
    	}
    	
    	// 将生成的验证码存入session中，以便进行校验
    	HttpSession session = request.getSession();
    	session.setAttribute("captcha", code.toLowerCase());
    	
    	// 绘制图片
    	graphics.dispose();
    	
    	// 将图片输出到response中
    	ImageIO.write(image, "JPEG", response.getOutputStream());
    }
    
    private static Color getRandomColor(){
    	return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
    
    /*
     * 参数依次为“要输出的字符串”、“x坐标”、“y坐标”，后面的rate是一个double类型，表示此次绘制的字间距是默认字间距的多少倍，g是画笔
     */
	public static void myDrawString(String str, int x, int y, double rate, Graphics g) {
		String tempStr = new String();
		int orgStringWight = g.getFontMetrics().stringWidth(str);
		int orgStringLength = str.length();
		int tempx = x;
		int tempy = y;
		while (str.length() > 0) {
			tempStr = str.substring(0, 1);
			str = str.substring(1, str.length());
			g.drawString(tempStr, tempx, tempy);
			tempx = (int) (tempx + (double) orgStringWight / (double) orgStringLength * rate);
		}
	}
}
