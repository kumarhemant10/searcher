package com.hk.prj.vite.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {
	@Autowired ModelMapper modelMapper;
}
