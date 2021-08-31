package com.crledu.auto.material.infrared;

import com.crledu.auto.material.Application;
import com.crledu.auto.material.grating.biz.service.BaseInfraredGratingService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@Transactional
public class InfraredGratingServiceTest {

    @Resource
    private BaseInfraredGratingService infraredGratingService;

    public void testImportInfraredGratingData(){
    }
}
