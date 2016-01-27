package me.wilk.robert.asme.controller;

import me.wilk.robert.asme.entity.Something;
import me.wilk.robert.asme.service.SomethingService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Robert Wilk
 *         Created on 1/20/2016.
 */
@Controller
public class SomethingController {

    @Autowired
    private SomethingService somethingService;

    @ModelAttribute(value = "something")
    public Something construct() {
        return new Something();
    }

    @ResponseBody
    @RequestMapping(value = "/something/loadEntity/{id}", method = RequestMethod.GET)
    public Something loadEntity(@PathVariable("id") Long id) {
        return somethingService.findOne(id);
    }

    @ResponseBody
    @RequestMapping(value = "/something/loadSomethingTable")
    public List<Something> loadSomethingTable() {
        return somethingService.findAll();
    }

    @RequestMapping(value = "something/list", method = RequestMethod.GET)
    public ModelAndView list() {
        return new ModelAndView("something/list", "somethings", somethingService.findAll());
    }

    @RequestMapping(value = "something/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("something/create");
    }

    @RequestMapping(value = "something/create", method = RequestMethod.POST)
    public void create(@ModelAttribute(value = "something") Something something) {
        somethingService.save(something);
    }

    @ResponseBody
    @RequestMapping(value = "something/update", method = RequestMethod.POST)
    public void update(@ModelAttribute("something") Something something) {
        somethingService.save(something);
    }

    @ResponseBody
    @RequestMapping(value = "something/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable("id") Long id) {
        somethingService.delete(id);
    }

    @PostConstruct
    public void initDataForTesting() {
        String[] names = {
          "Rob", "Jon", "Tom"
        };
        List<Something> somethingList = new ArrayList<>();
        for (int i = 0; i < names.length; ++i) {
            Something s = new Something();
            s.setId((long) (i + 1));
            s.setName(names[i]);
            somethingList.add(s);
        }
        somethingService.save(somethingList);
    }
}