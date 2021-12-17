/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.HashMap;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import pojos.Agelimit;
import pojos.Analogdigital;
import pojos.Brand;
import pojos.Casesize;
import pojos.Casetype;
import pojos.Dialcolor;
import pojos.Grade;
import pojos.Maincolor;
import pojos.Movement;
import pojos.Packaging;
import pojos.Product;
import pojos.Strapcolor;
import pojos.Straptype;
import pojos.Watchshape;
import pojos.Waterresistency;
import pojos.Weight;

/**
 *
 * @author Supun Madushanka
 */
public class AddNewProduct {

    public synchronized String ItemCode() {
        Session session = null;
        try {
            session = new classes.SessionConect().testConnection();
            Criteria itemcodeCriteria = session.createCriteria(pojos.Product.class);

            List<pojos.Product> products = itemcodeCriteria.list();

            if (!products.isEmpty()) {
                itemcodeCriteria.setProjection(Projections.max("idProduct"));
                List maxList = itemcodeCriteria.list();
                int i = Integer.parseInt(maxList.get(0).toString()) + 1;
                return "PRO" + i;
            } else {
                return "PRO1";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            session.flush();
            session.close();
        }

    }

    public synchronized void SaveProduct(final HashMap<String, Object> hm) {

        Session session = null;
        try {

            session = new classes.SessionConect().testConnection();

            pojos.Product product = new Product();

            if (hm.get("image") != null) {
                product.setImage((String) hm.get("image"));
            }

            if (hm.get("image1") != null) {
                product.setImage1((String) hm.get("image1"));
            }

            if (hm.get("image2") != null) {
                product.setImage2((String) hm.get("image2"));
            }

            product.setItemCode((String) hm.get("itemcode"));
            product.setProductName((String) hm.get("proname"));
            product.setBrand(SaveBrand((String) hm.get("brandname")));
            product.setMinQty((Double) hm.get("minqty"));

            Criteria productstatusCriteria = session.createCriteria(pojos.Productstatus.class);
            productstatusCriteria.add(Restrictions.eq("productStatus", (String) hm.get("productstatus")));
            List<pojos.Productstatus> productstatuses = productstatusCriteria.list();

            if (!productstatuses.isEmpty()) {
                pojos.Productstatus productstatus = productstatuses.get(0);

                product.setProductstatus(productstatus);
            }

            Criteria targetgenCriteria = session.createCriteria(pojos.Gendertype.class);
            targetgenCriteria.add(Restrictions.eq("genderType", (String) hm.get("targetgen")));
            List<pojos.Gendertype> gendertypes = targetgenCriteria.list();

            if (!gendertypes.isEmpty()) {
                pojos.Gendertype gendertype = gendertypes.get(0);

                product.setGendertype(gendertype);
            }

            product.setStraptype(SaveStrapType((String) hm.get("straptype")));
            product.setCasetype(SaveCaseType((String) hm.get("casetype")));
            product.setCasesize(SaveCaseSize(Double.parseDouble((String) hm.get("caseheight")), Double.parseDouble((String) hm.get("casewidth")), Double.parseDouble((String) hm.get("caseweight"))));
            product.setMaincolor(SaveMaincolor((String) hm.get("mcolor")));
            product.setStrapcolor(SaveStrapcolor((String) hm.get("strapcolor")));
            product.setDialcolor(SaveDialcolor((String) hm.get("dialcolor")));
            product.setMovement(SaveMovement((String) hm.get("movement")));
            product.setGrade(SaveGrade((String) hm.get("grade")));
            product.setAgelimit(SaveAgelimit((String) hm.get("agelimit")));
            product.setWaterresistency(SaveWaterresistency((String) hm.get("waterresistency")));
            product.setWeight(SaveWeight((String) hm.get("weight")));
            product.setWatchshape(SaveWatchshape((String) hm.get("watchshape")));
            product.setPackaging(SavePackaging((String) hm.get("packaging")));
            product.setAnalogdigital(SaveAnalogdigital((String) hm.get("analogdigital")));

            product.setSearchWord(CreateSearchWord((String) hm.get("proname"), (String) hm.get("brandname")));

            Transaction t = session.beginTransaction();
            session.save(product);
            System.out.println("before");
            t.commit();
            System.out.println("product :" + product + " commited..!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }

    }

    private synchronized String CreateSearchWord(String pname, String bname) {
        String searchword = "";
        try {

            searchword = bname + " " + pname;

            return searchword;
        } catch (Exception e) {

            e.printStackTrace();
            return "";
        }

    }

    private pojos.Casesize SaveCaseSize(double caseheight, double casewidth, double caseweight) {
        Session session = null;
        pojos.Casesize casesize = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();
            casesize = new Casesize();
            casesize.setCaseHeight(caseheight);
            casesize.setCaseWidth(casewidth);
            casesize.setCaseWeight(caseweight);

            session.save(casesize);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return casesize;
        }
    }

    private pojos.Brand SaveBrand(String brand1) {
        Session session = null;
        pojos.Brand brand = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria brandnameCriteria = session.createCriteria(pojos.Brand.class);
            brandnameCriteria.add(Restrictions.eq("brand", brand1));

            List<pojos.Brand> brands = brandnameCriteria.list();

            if (!brands.isEmpty()) {
                brand = brands.get(0);
            } else {
                brand = new Brand();
                brand.setBrand(brand1);
                session.save(brand);
                t.commit();

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return brand;

        }

    }

    private pojos.Straptype SaveStrapType(String straptype1) {
        Session session = null;
        pojos.Straptype straptype = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria straptypeCriteria = session.createCriteria(pojos.Straptype.class);
            straptypeCriteria.add(Restrictions.eq("strapType", straptype1));
            List<pojos.Straptype> straptypes = straptypeCriteria.list();

            if (!straptypes.isEmpty()) {
                straptype = straptypes.get(0);

            } else {
                straptype = new Straptype();
                straptype.setStrapType(straptype1);
                session.save(straptype);
                t.commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return straptype;
        }
    }

    private pojos.Casetype SaveCaseType(String casetype1) {
        Session session = null;
        pojos.Casetype casetype = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria casetypeCriteria = session.createCriteria(pojos.Casetype.class);
            casetypeCriteria.add(Restrictions.eq("caseType", casetype1));
            List<pojos.Casetype> casetypes = casetypeCriteria.list();

            if (!casetypes.isEmpty()) {
                casetype = casetypes.get(0);
            } else {
                casetype = new Casetype();
                casetype.setCaseType(casetype1);
                session.save(casetype);
                t.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return casetype;
        }
    }

    private pojos.Maincolor SaveMaincolor(String maincolor1) {
        Session session = null;
        pojos.Maincolor maincolor = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria mcolrCriteria = session.createCriteria(pojos.Maincolor.class);
            mcolrCriteria.add(Restrictions.eq("color", maincolor1));
            List<pojos.Maincolor> maincolors = mcolrCriteria.list();

            if (!maincolors.isEmpty()) {
                maincolor = maincolors.get(0);
            } else {
                maincolor = new Maincolor();
                maincolor.setColor(maincolor1);
                session.save(maincolor);
                t.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return maincolor;
        }
    }

    private pojos.Strapcolor SaveStrapcolor(String Strapcolor1) {
        Session session = null;
        pojos.Strapcolor strapcolor = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria strapcolrCriteria = session.createCriteria(pojos.Strapcolor.class);
            strapcolrCriteria.add(Restrictions.eq("strapColor", Strapcolor1));
            List<pojos.Strapcolor> strapcolors = strapcolrCriteria.list();

            if (!strapcolors.isEmpty()) {
                strapcolor = strapcolors.get(0);
            } else {
                strapcolor = new Strapcolor();
                strapcolor.setStrapColor(Strapcolor1);
                session.save(strapcolor);
                t.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return strapcolor;
        }
    }

    private pojos.Dialcolor SaveDialcolor(String dialcolor1) {
        Session session = null;
        pojos.Dialcolor dialcolor = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria dialcolrCriteria = session.createCriteria(pojos.Dialcolor.class);
            dialcolrCriteria.add(Restrictions.eq("dialColor", dialcolor1));
            List<pojos.Dialcolor> dialcolors = dialcolrCriteria.list();

            if (!dialcolors.isEmpty()) {
                dialcolor = dialcolors.get(0);
            } else {
                dialcolor = new Dialcolor();
                dialcolor.setDialColor(dialcolor1);
                session.save(dialcolor);
                t.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return dialcolor;
        }
    }

    private pojos.Movement SaveMovement(String movement1) {
        Session session = null;
        pojos.Movement movement = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria movementCriteria = session.createCriteria(pojos.Movement.class);
            movementCriteria.add(Restrictions.eq("movement", movement1));
            List<pojos.Movement> movements = movementCriteria.list();

            if (!movements.isEmpty()) {
                movement = movements.get(0);
            } else {
                movement = new Movement();
                movement.setMovement(movement1);
                session.save(movement);
                t.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return movement;
        }
    }

    private pojos.Grade SaveGrade(String grade1) {
        Session session = null;
        pojos.Grade grade = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria gradeCriteria = session.createCriteria(pojos.Grade.class);
            gradeCriteria.add(Restrictions.eq("grade", grade1));
            List<pojos.Grade> grades = gradeCriteria.list();

            if (!grades.isEmpty()) {
                grade = grades.get(0);

            } else {
                grade = new Grade();
                grade.setGrade(grade1);
                session.save(grade);
                t.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return grade;
        }
    }

    private pojos.Agelimit SaveAgelimit(String agelimit1) {
        Session session = null;
        pojos.Agelimit agelimit = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria agelimitCriteria = session.createCriteria(pojos.Agelimit.class);
            agelimitCriteria.add(Restrictions.eq("ageLimit", agelimit1));
            List<pojos.Agelimit> agelimits = agelimitCriteria.list();

            if (!agelimits.isEmpty()) {
                agelimit = agelimits.get(0);
            } else {
                agelimit = new Agelimit();
                agelimit.setAgeLimit(agelimit1);
                session.save(agelimit);
                t.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return agelimit;
        }
    }

    private pojos.Waterresistency SaveWaterresistency(String waterressist1) {
        Session session = null;
        pojos.Waterresistency waterresistency = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria waterresistencyCriteria = session.createCriteria(pojos.Waterresistency.class);
            waterresistencyCriteria.add(Restrictions.eq("rate", waterressist1));
            List<pojos.Waterresistency> waterresistencys = waterresistencyCriteria.list();

            if (!waterresistencys.isEmpty()) {
                waterresistency = waterresistencys.get(0);
            } else {
                waterresistency = new Waterresistency();
                waterresistency.setRate(waterressist1);
                session.save(waterresistency);
                t.commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return waterresistency;
        }
    }

    private pojos.Weight SaveWeight(String weight1) {
        Session session = null;
        pojos.Weight weight = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria weightCriteria = session.createCriteria(pojos.Weight.class);
            weightCriteria.add(Restrictions.eq("weight", Double.parseDouble(weight1)));
            List<pojos.Weight> weights = weightCriteria.list();

            if (!weights.isEmpty()) {
                weight = weights.get(0);
            } else {
                weight = new Weight();
                weight.setWeight(Double.parseDouble(weight1));
                session.save(weight);
                t.commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return weight;
        }
    }

    private pojos.Watchshape SaveWatchshape(String watchshape1) {
        Session session = null;
        pojos.Watchshape watchshape = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria watchshapeCriteria = session.createCriteria(pojos.Watchshape.class);
            watchshapeCriteria.add(Restrictions.eq("watchShape", watchshape1));
            List<pojos.Watchshape> watchshapes = watchshapeCriteria.list();

            if (!watchshapes.isEmpty()) {
                watchshape = watchshapes.get(0);
            } else {
                watchshape = new Watchshape();
                watchshape.setWatchShape(watchshape1);
                session.save(watchshape);
                t.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return watchshape;
        }
    }

    private pojos.Packaging SavePackaging(String packaging1) {
        Session session = null;
        pojos.Packaging packaging = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria packagingCriteria = session.createCriteria(pojos.Packaging.class);
            packagingCriteria.add(Restrictions.eq("packagingType", packaging1));
            List<pojos.Packaging> packagings = packagingCriteria.list();

            if (!packagings.isEmpty()) {
                packaging = packagings.get(0);
            } else {
                packaging = new Packaging();
                packaging.setPackagingType(packaging1);
                session.save(packaging);
                t.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return packaging;
        }
    }

    private pojos.Analogdigital SaveAnalogdigital(String analogdigi1) {
        Session session = null;
        pojos.Analogdigital analogdigital = null;
        try {
            session = new classes.SessionConect().testConnection();
            Transaction t = session.beginTransaction();

            Criteria andigiCriteria = session.createCriteria(pojos.Analogdigital.class);
            andigiCriteria.add(Restrictions.eq("analogDigital", analogdigi1));
            List<pojos.Analogdigital> analogdigitals = andigiCriteria.list();

            if (!analogdigitals.isEmpty()) {
                analogdigital = analogdigitals.get(0);

            } else {
                analogdigital = new Analogdigital();
                analogdigital.setAnalogDigital(analogdigi1);
                session.save(analogdigital);
                t.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return analogdigital;
        }
    }
}
