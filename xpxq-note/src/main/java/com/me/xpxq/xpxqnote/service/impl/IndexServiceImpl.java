package com.me.xpxq.xpxqnote.service.impl;

import com.me.xpxq.xpxqcommon.util.Res;
import com.me.xpxq.xpxqnote.dao.CNoteDao;
import com.me.xpxq.xpxqnote.pojo.CNote;
import com.me.xpxq.xpxqnote.service.IndexService;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.element.TypeElement;
import java.util.List;
import java.util.Objects;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    CNoteDao cNoteDao;
    @Override
    public Res getIndexList(String type) {
        String column = "";
        if ("l".equals(type)){
            column = "view";
        }else if("r".equals(type)){
            column = "good";
        }
        if ("".equals(column)){
            return Res.fail();
        }
        List<CNote> notes = cNoteDao.selectRankByCount(column);
        if (!Objects.isNull(notes)){
            return Res.ok(notes);
        }
        return Res.fail();
    }
}
