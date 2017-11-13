package com.example.demo.service.utils;

import com.example.demo.dao.map.DistrictDao;
import com.example.demo.entity.data.District;
import com.example.demo.enums.DeviceTypeEnum;
import com.example.demo.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yang
 * @create_at 17-11-9
 **/
public class RegistCodeGenerater {
    private char[] numChar={'0','0','0','0','0'};

    public String generate(District district, String deviceCode, String deviceSName,long date,long deviceNum)throws Exception{
        String districtCode=district.getProvinceCode();
        if(district.getCitySeqCode()!=null){
            districtCode=districtCode+district.getCitySeqCode();
            if(district.getAreaSeqCode()!=null){
                districtCode=districtCode+district.getAreaSeqCode();
            }
        }
        String registCode=deviceSName+deviceCode.substring(1,3)+districtCode;
        String time=UtilServiceImpl.long2String(date,"yy");
        return registCode=registCode+getNumChar(deviceNum)+"("+time+")";
    }

    private String getNumChar(long deviceNum) {
        deviceNum=deviceNum+1;
        for(int i=10,j=4;i<1000000;i=i*10,j--){
            numChar[j]= (deviceNum%i+"").toCharArray()[0];
            if(deviceNum/i<1){
                break;
            }
        }
        if(deviceNum/10000>=10){
            int num=(int)deviceNum/10000-10;
            numChar[0]=UtilServiceImpl.CODE[num].toCharArray()[0];
        }
        return String.valueOf(numChar);
    }


}
