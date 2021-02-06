package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVo;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService service;

    @GetMapping("/register")
    public void registerGET(BoardVo boardVo, Model model, HttpServletRequest request) throws Exception {
        logger.info("Client request :: " + request.getRequestURL());
        logger.info("RequestMethod :: " + request.getMethod());
    }

    @PostMapping("/register")
    public String registPOST(BoardVo boardVo, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        logger.info("Client request ::" + request.getRequestURL());
        logger.info("RequestMethod :: " + request.getMethod());

        logger.info(boardVo.toString());

        service.regist(boardVo);

        redirectAttributes.addFlashAttribute("msg", "SUCCESS"); // URI 상 보이지 않는 숨겨진 데이터의 형태로 전달된다.

        return "redirect:/board/listAll";
    }

    @GetMapping("/listAll")
    public void listAll(Model model, HttpServletRequest request) throws Exception {
        logger.info("Client request ::" + request.getRequestURL());
        logger.info("RequestMethod :: " + request.getMethod());

        model.addAttribute("list", service.listAll());
    }

    @GetMapping("/read")
    public void read(@RequestParam("bno") int bno, Model model, HttpServletRequest request) throws Exception {
        logger.info("Client request ::" + request.getRequestURL());
        logger.info("RequestMethod :: " + request.getMethod());

        model.addAttribute("boardVO", service.read(bno));
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") int bno, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        logger.info("Client request ::" + request.getRequestURL());
        logger.info("RequestMethod :: " + request.getMethod());


        service.remove(bno);
        redirectAttributes.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/board/listAll";
    }

    @GetMapping("/modify")
    public void modifyGET(int bno, Model model, HttpServletRequest request) throws Exception {
        logger.info("Client request ::" + request.getRequestURL());
        logger.info("RequestMethod :: " + request.getMethod());

        model.addAttribute("boardVO", service.read(bno));
    }

    @PostMapping("/modify")
    public String modifyPOST(BoardVo boardVo, RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {
        logger.info("request :: {}, Method :: {}", request.getRequestURL(), request.getMethod());
        logger.info("RequestMethod :: " + request.getMethod());

        service.modify(boardVo);
        redirectAttributes.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/board/listAll";
    }

    // 페이징 처리
    @GetMapping("/listCri")
    public void listAll(Criteria cri, Model model, HttpServletRequest request) throws Exception {
        logger.info("request :: '{}', Method :: '{}'", request.getRequestURL(), request.getMethod());

        model.addAttribute("list", service.listCriteria(cri));
    }
}
