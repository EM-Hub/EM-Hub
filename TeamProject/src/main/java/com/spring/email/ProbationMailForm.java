package com.spring.email;

import com.spring.biz.vo.MemberVO;
import com.spring.biz.vo.ProbationVO;

public class ProbationMailForm {
	private String text;
	
	public ProbationMailForm(MemberVO memberVO, ProbationVO probationVO){
		text = "<body class=\"clean-body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #f9f9f9\">\r\n" + 
				"  <!--[if IE]><div class=\"ie-container\"><![endif]-->\r\n" + 
				"  <!--[if mso]><div class=\"mso-container\"><![endif]-->\r\n" + 
				"  <table class=\"nl-container\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #f9f9f9;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
				"  <tbody>\r\n" + 
				"  <tr style=\"vertical-align: top\">\r\n" + 
				"    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n" + 
				"    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #f9f9f9;\"><![endif]-->\r\n" + 
				"    \r\n" + 
				"\r\n" + 
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: #f9f9f9\">\r\n" + 
				"  <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f9f9f9;\" class=\"u-row\">\r\n" + 
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: #f9f9f9;\">\r\n" + 
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #f9f9f9;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #f9f9f9;\"><![endif]-->\r\n" + 
				"      \r\n" + 
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
				"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n" + 
				"  <div style=\"width: 100% !important;\">\r\n" + 
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n" + 
				"  \r\n" + 
				"<table id=\"u_content_divider_2\" class=\"u_content_divider\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n" + 
				"  <tbody>\r\n" + 
				"    <tr>\r\n" + 
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:15px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n" + 
				"        \r\n" + 
				"  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #f9f9f9;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\r\n" + 
				"    <tbody>\r\n" + 
				"      <tr style=\"vertical-align: top\">\r\n" + 
				"        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\r\n" + 
				"          <span>&#160;</span>\r\n" + 
				"        </td>\r\n" + 
				"      </tr>\r\n" + 
				"    </tbody>\r\n" + 
				"  </table>\r\n" + 
				"\r\n" + 
				"      </td>\r\n" + 
				"    </tr>\r\n" + 
				"  </tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"<!--[if (mso)|(IE)]></td><![endif]-->\r\n" + 
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n" + 
				"  <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #161a39;\" class=\"u-row\">\r\n" + 
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: #161a39;\">\r\n" + 
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #161a39;\"><![endif]-->\r\n" + 
				"      \r\n" + 
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
				"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n" + 
				"  <div style=\"width: 100% !important;\">\r\n" + 
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n" + 
				"  \r\n" + 
				"<table id=\"u_content_image_4\" class=\"u_content_image\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n" + 
				"  <tbody>\r\n" + 
				"    <tr>\r\n" + 
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:30px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n" + 
				"        \r\n" + 
				"<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n" + 
				"  <tr>\r\n" + 
				"    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\r\n" + 
				"      \r\n" + 
				"      <img align=\"center\" border=\"0\" src=\"cid:image-5.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;width: 52%;max-width: 280.8px;\" width=\"280.8\" class=\"v-src-width v-src-max-width\"/>\r\n" + 
				"      \r\n" + 
				"    </td>\r\n" + 
				"  </tr>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"      </td>\r\n" + 
				"    </tr>\r\n" + 
				"  </tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"<!--[if (mso)|(IE)]></td><![endif]-->\r\n" + 
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n" + 
				"  <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\" class=\"u-row\">\r\n" + 
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: #ffffff;\">\r\n" + 
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\r\n" + 
				"      \r\n" + 
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
				"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n" + 
				"  <div style=\"width: 100% !important;\">\r\n" + 
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n" + 
				"  \r\n" + 
				"<table id=\"u_content_text_4\" class=\"u_content_text\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n" + 
				"  <tbody>\r\n" + 
				"    <tr>\r\n" + 
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 40px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n" + 
				"        \r\n" + 
				"  <div class=\"v-text-align\" style=\"color: #000000; line-height: 140%; text-align: left; word-wrap: break-word;\">\r\n" + 
				"    <p style=\"line-height: 140%; font-size: 14px;\"><span style=\"color: #666666; font-size: 14px; line-height: 19.6px;\"><span style=\"font-size: 18px; line-height: 25.2px;\"><span style=\"color: #000000; font-size: 18px; line-height: 25.2px;\"><strong>"+ memberVO.getMemName() +" ("+ memberVO.getMemId() +")</strong></span>님, </span></span></p>\r\n" + 
				"<p style=\"font-size: 14px; line-height: 140%;\">&nbsp;</p>\r\n" + 
				"<p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 18px; line-height: 25.2px; color: #666666;\">다음과 같은 이유로 학사경고 처리되었음을 </span></p>\r\n" + 
				"<p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 18px; line-height: 25.2px; color: #666666;\">알려드립니다.</span></p>\r\n" + 
				"<p style=\"font-size: 14px; line-height: 140%;\">&nbsp;</p>\r\n" + 
				"<p style=\"font-size: 14px; line-height: 140%;\">&nbsp;</p>\r\n" + 
				"<ul>\r\n" + 
				"<li dir=\"ltr\" style=\"font-size: 14px; line-height: 19.6px;\"><span style=\"font-size: 18px; line-height: 25.2px; color: #000000;\">&nbsp; 학번: "+ memberVO.getMemId() +"</span></li>\r\n" + 
				"<li dir=\"ltr\" style=\"font-size: 14px; line-height: 19.6px;\"><span style=\"font-size: 18px; line-height: 25.2px; color: #000000;\">&nbsp; 이름: "+ memberVO.getMemName() +"</span></li>\r\n" + 
				"<li dir=\"ltr\" style=\"font-size: 14px; line-height: 19.6px;\"><span style=\"font-size: 18px; line-height: 25.2px; color: #000000;\">&nbsp; 해당학기: "+ Integer.toString(probationVO.getSemCode()).substring(0, 4) +"년도 " + Integer.toString(probationVO.getSemCode()).substring(5, 6) +"학기</span></li>\r\n" + 
				"<li dir=\"ltr\" style=\"font-size: 14px; line-height: 19.6px;\"><span style=\"font-size: 18px; line-height: 25.2px; color: #000000;\">&nbsp; 학사경고 사유: "+ probationVO.getProbReason() +"</span></li>\r\n" + 
				"</ul>\r\n" + 
				"<p style=\"line-height: 140%; font-size: 14px;\">&nbsp;</p>\r\n" + 
				"<p style=\"line-height: 140%; font-size: 14px;\">&nbsp;</p>\r\n" + 
				"<p style=\"line-height: 140%; font-size: 14px;\"><span style=\"color: #666666; font-size: 14px; line-height: 19.6px;\"><span style=\"font-size: 18px; line-height: 25.2px; color: red; font-weight: bold;\">누적 3회의 학사경고는 제적처리 될 수 있습니다.</span></span></p>\r\n" + 
				"<p style=\"line-height: 140%; font-size: 14px;\"><span style=\"color: #666666; font-size: 14px; line-height: 19.6px;\"><span style=\"font-size: 18px; line-height: 25.2px;\">추가적으로 궁금하신 사항은 아래의 번호로</span></span><span style=\"font-size: 18px; color: #666666; line-height: 25.2px;\"> 문의하세요.</span></p>\r\n" + 
				"<p style=\"line-height: 140%; font-size: 14px;\">&nbsp;</p>\r\n" + 
				"<p style=\"line-height: 140%; font-size: 14px;\"><span style=\"font-size: 18px; color: #666666; line-height: 25.2px;\">KH대학교 학생관리과(052-214-5248)</span></p>\r\n" + 
				"<p style=\"font-size: 14px; line-height: 140%;\">&nbsp;</p>\r\n" + 
				"<p style=\"font-size: 14px; line-height: 140%;\">&nbsp;</p>\r\n" + 
				"  </div>\r\n" + 
				"\r\n" + 
				"      </td>\r\n" + 
				"    </tr>\r\n" + 
				"  </tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"<table id=\"u_content_button_1\" class=\"u_content_button\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n" + 
				"  <tbody>\r\n" + 
				"    <tr>\r\n" + 
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 40px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n" + 
				"        \r\n" + 
				"<div class=\"v-text-align\" align=\"left\">\r\n" + 
				"  <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;font-family:'Lato',sans-serif;\"><tr><td class=\"v-text-align\" style=\"font-family:'Lato',sans-serif;\" align=\"left\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"\" style=\"height:51px; v-text-anchor:middle; width:235px;\" arcsize=\"2%\" stroke=\"f\" fillcolor=\"#18163a\"><w:anchorlock/><center style=\"color:#FFFFFF;font-family:'Lato',sans-serif;\"><![endif]-->\r\n" + 
				"    <a href=\"\" target=\"_blank\" class=\"v-size-width\" style=\"box-sizing: border-box;display: inline-block;font-family:'Lato',sans-serif;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #FFFFFF; background-color: #18163a; border-radius: 1px; -webkit-border-radius: 1px; -moz-border-radius: 1px; width:auto; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;\">\r\n" + 
				"      <span class=\"v-padding\" style=\"display:block;padding:15px 40px;line-height:120%;\"><span style=\"font-size: 18px; line-height: 21.6px;\">KH대학교&nbsp;바로가기</span><br /></span>\r\n" + 
				"    </a>\r\n" + 
				"  <!--[if mso]></center></v:roundrect></td></tr></table><![endif]-->\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"      </td>\r\n" + 
				"    </tr>\r\n" + 
				"  </tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"<table id=\"u_content_text_5\" class=\"u_content_text\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n" + 
				"  <tbody>\r\n" + 
				"    <tr>\r\n" + 
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 40px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n" + 
				"        \r\n" + 
				"  <div class=\"v-text-align\" style=\"color: #000000; line-height: 140%; text-align: left; word-wrap: break-word;\">\r\n" + 
				"    <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"color: #888888; font-size: 14px; line-height: 19.6px;\"><em><span style=\"font-size: 16px; line-height: 22.4px;\">Please ignore this email if you are not student of KH University.</span></em></span><br /><span style=\"color: #888888; font-size: 14px; line-height: 19.6px;\"><em><span style=\"font-size: 16px; line-height: 22.4px;\">&nbsp;</span></em></span></p>\r\n" + 
				"  </div>\r\n" + 
				"\r\n" + 
				"      </td>\r\n" + 
				"    </tr>\r\n" + 
				"  </tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"<!--[if (mso)|(IE)]></td><![endif]-->\r\n" + 
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n" + 
				"  <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #18163a;\" class=\"u-row\">\r\n" + 
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: #18163a;\">\r\n" + 
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #18163a;\"><![endif]-->\r\n" + 
				"      \r\n" + 
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"width: 300px;padding: 20px 20px 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
				"<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\r\n" + 
				"  <div style=\"width: 100% !important;\">\r\n" + 
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 20px 20px 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n" + 
				"  \r\n" + 
				"<table id=\"u_content_text_7\" class=\"u_content_text\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n" + 
				"  <tbody>\r\n" + 
				"    <tr>\r\n" + 
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n" + 
				"        \r\n" + 
				"  <div class=\"v-text-align\" style=\"color: #000000; line-height: 140%; text-align: left; word-wrap: break-word;\">\r\n" + 
				"    <p style=\"font-size: 14px; line-height: 140%;\"><strong><span style=\"font-size: 16px; line-height: 22.4px; color: #ecf0f1;\">Contact</span></strong></p>\r\n" + 
				"<p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 14px; line-height: 19.6px; color: #ecf0f1;\">KH대학교 학생관리과</span></p>\r\n" + 
				"<p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 14px; line-height: 19.6px; color: #ecf0f1;\">052-214-5248 unipotal2020@gmail.com</span></p>\r\n" + 
				"  </div>\r\n" + 
				"\r\n" + 
				"      </td>\r\n" + 
				"    </tr>\r\n" + 
				"  </tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"<!--[if (mso)|(IE)]></td><![endif]-->\r\n" + 
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"width: 300px;padding: 0px 0px 0px 20px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
				"<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\r\n" + 
				"  <div style=\"width: 100% !important;\">\r\n" + 
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px 0px 0px 20px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n" + 
				"  \r\n" + 
				"<table id=\"u_content_social_1\" class=\"u_content_social\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n" + 
				"  <tbody>\r\n" + 
				"    <tr>\r\n" + 
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:25px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n" + 
				"        \r\n" + 
				"<div align=\"left\">\r\n" + 
				"  <div style=\"display: table; max-width:187px;\">\r\n" + 
				"  <!--[if (mso)|(IE)]><table width=\"187\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"border-collapse:collapse;\" align=\"left\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:187px;\"><tr><![endif]-->\r\n" + 
				"  \r\n" + 
				"    \r\n" + 
				"    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\r\n" + 
				"    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;Margin-right: 15px\">\r\n" + 
				"      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n" + 
				"        <a href=\" \" title=\"Facebook\" target=\"_blank\">\r\n" + 
				"          <img src=\"cid:image-1.png\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n" + 
				"        </a>\r\n" + 
				"      </td></tr>\r\n" + 
				"    </tbody></table>\r\n" + 
				"    <!--[if (mso)|(IE)]></td><![endif]-->\r\n" + 
				"    \r\n" + 
				"    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\r\n" + 
				"    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;Margin-right: 15px\">\r\n" + 
				"      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n" + 
				"        <a href=\" \" title=\"Twitter\" target=\"_blank\">\r\n" + 
				"          <img src=\"cid:image-3.png\" alt=\"Twitter\" title=\"Twitter\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n" + 
				"        </a>\r\n" + 
				"      </td></tr>\r\n" + 
				"    </tbody></table>\r\n" + 
				"    <!--[if (mso)|(IE)]></td><![endif]-->\r\n" + 
				"    \r\n" + 
				"    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\r\n" + 
				"    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;Margin-right: 15px\">\r\n" + 
				"      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n" + 
				"        <a href=\" \" title=\"Instagram\" target=\"_blank\">\r\n" + 
				"          <img src=\"cid:image-2.png\" alt=\"Instagram\" title=\"Instagram\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n" + 
				"        </a>\r\n" + 
				"      </td></tr>\r\n" + 
				"    </tbody></table>\r\n" + 
				"    <!--[if (mso)|(IE)]></td><![endif]-->\r\n" + 
				"    \r\n" + 
				"    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 0px;\" valign=\"top\"><![endif]-->\r\n" + 
				"    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;Margin-right: 0px\">\r\n" + 
				"      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n" + 
				"        <a href=\" \" title=\"LinkedIn\" target=\"_blank\">\r\n" + 
				"          <img src=\"cid:image-4.png\" alt=\"LinkedIn\" title=\"LinkedIn\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n" + 
				"        </a>\r\n" + 
				"      </td></tr>\r\n" + 
				"    </tbody></table>\r\n" + 
				"    <!--[if (mso)|(IE)]></td><![endif]-->\r\n" + 
				"    \r\n" + 
				"    \r\n" + 
				"    <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"      </td>\r\n" + 
				"    </tr>\r\n" + 
				"  </tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"<table id=\"u_content_text_6\" class=\"u_content_text\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n" + 
				"  <tbody>\r\n" + 
				"    <tr>\r\n" + 
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:5px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n" + 
				"        \r\n" + 
				"  <div class=\"v-text-align\" style=\"color: #000000; line-height: 140%; text-align: left; word-wrap: break-word;\">\r\n" + 
				"    <p style=\"line-height: 140%; font-size: 14px;\"><span style=\"font-size: 14px; line-height: 19.6px;\"><span style=\"color: #ecf0f1; font-size: 14px; line-height: 19.6px;\"><span style=\"line-height: 19.6px; font-size: 14px;\">Company &copy;&nbsp; All Rights Reserved</span></span></span></p>\r\n" + 
				"  </div>\r\n" + 
				"\r\n" + 
				"      </td>\r\n" + 
				"    </tr>\r\n" + 
				"  </tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"<!--[if (mso)|(IE)]></td><![endif]-->\r\n" + 
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: #f9f9f9\">\r\n" + 
				"  <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #1c103b;\" class=\"u-row\">\r\n" + 
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: #1c103b;\">\r\n" + 
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #f9f9f9;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #1c103b;\"><![endif]-->\r\n" + 
				"      \r\n" + 
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
				"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n" + 
				"  <div style=\"width: 100% !important;\">\r\n" + 
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n" + 
				"  \r\n" + 
				"<table id=\"u_content_divider_1\" class=\"u_content_divider\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n" + 
				"  <tbody>\r\n" + 
				"    <tr>\r\n" + 
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:15px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n" + 
				"        \r\n" + 
				"  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #1c103b;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\r\n" + 
				"    <tbody>\r\n" + 
				"      <tr style=\"vertical-align: top\">\r\n" + 
				"        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\r\n" + 
				"          <span>&#160;</span>\r\n" + 
				"        </td>\r\n" + 
				"      </tr>\r\n" + 
				"    </tbody>\r\n" + 
				"  </table>\r\n" + 
				"\r\n" + 
				"      </td>\r\n" + 
				"    </tr>\r\n" + 
				"  </tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"<!--[if (mso)|(IE)]></td><![endif]-->\r\n" + 
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n" + 
				"  <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f9f9f9;\" class=\"u-row\">\r\n" + 
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: #f9f9f9;\">\r\n" + 
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #f9f9f9;\"><![endif]-->\r\n" + 
				"      \r\n" + 
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
				"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n" + 
				"  <div style=\"width: 100% !important;\">\r\n" + 
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n" + 
				"  \r\n" + 
				"<table id=\"u_content_text_11\" class=\"u_content_text\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n" + 
				"  <tbody>\r\n" + 
				"    <tr>\r\n" + 
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 40px 30px 20px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n" + 
				"        \r\n" + 
				"  <div class=\"v-text-align\" style=\"color: #000000; line-height: 140%; text-align: left; word-wrap: break-word;\">\r\n" + 
				"    \r\n" + 
				"  </div>\r\n" + 
				"\r\n" + 
				"      </td>\r\n" + 
				"    </tr>\r\n" + 
				"  </tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"<!--[if (mso)|(IE)]></td><![endif]-->\r\n" + 
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
				"    </td>\r\n" + 
				"  </tr>\r\n" + 
				"  </tbody>\r\n" + 
				"  </table>\r\n" + 
				"  <!--[if (mso)|(IE)]></div><![endif]-->\r\n" + 
				"  \r\n" + 
				"</body>";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
