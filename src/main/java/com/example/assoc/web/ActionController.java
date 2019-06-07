package com.example.assoc.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.assoc.dao.ContactRepository;
import com.example.assoc.dao.MediaRepository;
import com.example.assoc.dao.OrganisateurRepository;
import com.example.assoc.dao.OrganismeRepository;
import com.example.assoc.dao.PartenaireRepository;
import com.example.assoc.dao.QuartierRepository;
import com.example.assoc.dao.RessourceRepository;
import com.example.assoc.dao.SituationRepository;
import com.example.assoc.dao.TypemediaRepository;
import com.example.assoc.entities.Action;
import com.example.assoc.entities.Contact;
import com.example.assoc.entities.Media;
import com.example.assoc.entities.Organisateur;
import com.example.assoc.entities.Organisme;
import com.example.assoc.entities.Partenaire;
import com.example.assoc.entities.Personne;
import com.example.assoc.entities.Projet;
import com.example.assoc.entities.Quartier;
import com.example.assoc.entities.Ressource;
import com.example.assoc.entities.Situation;
import com.example.assoc.entities.Typeaction;
import com.example.assoc.entities.Typemedia;
import com.example.assoc.metier.ActionMetierImp;
import com.example.assoc.metier.OrganismeMetierImp;
import com.example.assoc.metier.ProjetMetierImp;
import com.example.assoc.metier.QuartierMetierImp;
import com.example.assoc.metier.RessourceMetierImp;
import com.example.assoc.metier.TypeActionMetierImp;

@Controller
public class ActionController {
	
	//public static String uploadDirectory = System.getProperty("user.dir")+"/down";
	@Value("${dir.images}")
	private String imageDir;
	 //private final Path rootLocation = Paths.get("C:/Users/bad12/Desktop/Stage");
	@PersistenceContext
    EntityManager entityManager;
	@Autowired
	private TypemediaRepository typemediarepo;
	@Autowired
	private SituationRepository situationrepo;
	@Autowired
	private MediaRepository mediarepo;
	@Autowired
	private ActionMetierImp actionMetierImp;
	@Autowired
	private ContactRepository contact;
	
	@Autowired
	RessourceRepository ressourcerepo;
	
	@Autowired
	private TypeActionMetierImp typeaction;
	
	
	@Autowired
	private ProjetMetierImp projet;
	@Autowired
	private QuartierMetierImp quartier;
	
	@Autowired
	private OrganismeRepository organismerepo;
	
	@Autowired
	private RessourceMetierImp ressourceMetierImp;
	
	@Autowired
	private OrganisateurRepository organisateurRepo;
	@Autowired
	private PartenaireRepository partnerRepo;
	

	ArrayList<Personne> maListe = new ArrayList<Personne>();
	/*@RequestMapping("/data")
	public String index()
	{
		return "index";
	}*/
	@RequestMapping("/ress")
	public String rssc(Model model)
	{
		List<Action> actions=actionMetierImp.getAll();
		model.addAttribute("actions", actions);
		
		List<Ressource> ressources=ressourceMetierImp.getAll();
		model.addAttribute("ressources", ressources);
		
		return "Ressource";
	}
	
	@RequestMapping("/deleteRess")
	public String DeleteRessource(Model model,@RequestParam("RessId") String RessId)
	{  
		try {
		Optional<Ressource> ressource=ressourceMetierImp.find(Integer.parseInt(RessId));
		ressourceMetierImp.delete(ressource.get());
		
		}catch(Exception e){
			model.addAttribute("error", " Error while deleting ressource " );
			System.out.println("Delet Error XXXXXXXXX :"+e);}
		return rssc( model);
	}
	
	@RequestMapping("/PagePartner")
	public String PagePartner(Model model) {
		
		List<Action> actions=actionMetierImp.getAll();
		model.addAttribute("actions", actions);
		
		
		return"";
	}
	
	/*list partner action    */
	public List<Action> listpartner () {
        //category - object with needed id
		Query query;
		String qr="select a from assoc.action as a "  ;
		String qr2="SELECT p FROM action p JOIN p.partenaire c WHERE c.id = :id_partenaire";
           query = entityManager.createQuery(qr);
           
           //Query query = session.createQuery(hql);
           //List<Article> articles = query.list();
        		query.setParameter("id_partenaire", 1);

       return (List<Action>) query.getResultList();
   }
	
	
	@RequestMapping("/AddPartnerAction")
	public String PartnerAct(Model model,@RequestParam("idAction")String idAction) {
		
		return"";
	}
	
	@RequestMapping("/AddRess")
	public String AjoutRessource(Model model,double montant ,@RequestParam("idAction")String idAction,String description,RedirectAttributes redirectattribute)
	{
		if(description.matches("[a-zA-Z]+")==true  ) {
			Ressource ressource=new Ressource();
			ressource.setMontant(montant);
			Optional<Action> action=actionMetierImp.find(Integer.parseInt(idAction));
			ressource.setAction(action.get());
			ressource.setDescription(description);
			Ressource ress=ressourceMetierImp.add(ressource);
		if(!ress.equals(null)) {
			//model.addAttribute("message","Ressource bien ajouter avec le montant "+ressource.getMontant());
			redirectattribute.addFlashAttribute("message","Ressource bien ajouter avec le montant "+ressource.getMontant());
			}
			
			return "redirect:ress";
		}
			else {
				model.addAttribute("MsgDescription","Invalid input description");
				//email and organisme exist deja existe deja
				//System.out.println("email and organisme existe deja erreeeeer !!!");
				return rssc(model);
			}
		
		
		
	}
	@RequestMapping("/first")
	public String page(Model model) {
		//session.setAttribute("dddd", "dfdf");
		List<Quartier> quartiers=quartier.getAll();
		model.addAttribute("quartiers", quartiers);
		
		List<Projet> projets=projet.getAll();
		model.addAttribute("projets", projets);
		
		Optional<Organisme> organismes = organismerepo.findById(1);
		model.addAttribute( "organismes" , organismes.get());
		
		Optional<Contact> cntct = contact.findById(1);
		model.addAttribute( "cntct" , cntct.get());
		
		List<Typeaction> typesAct=typeaction.getAll();
		model.addAttribute("typesAct", typesAct);
		
		List<Action> actions=actionMetierImp.getAll();
		//List<Action> actions2=actionMetierImp.getMyActions(1);
		model.addAttribute("actions", actions);
		//List<Action> data=listpartner ();
		//System.out.println("********** First one **********"+data.get(0).getNom());
		
		/*List<Organisme> organismes=organisme.getAll();
		model.addAttribute("organismes", organismes);
		Optional<Contact> cnt=contact.findById(1);*/
		
		//List<Quartier> quartiers = quartierRepository.findAll();
		
		
		
		for(int i = 0 ; i < quartiers.size(); i++){
		 	
			 String donnee= quartiers.get(i).getNom();
			System.out.println("LLLLL"+donnee);
		 	
		 	}
	    
		return "page";
	}
	
	
	
	@RequestMapping("/NewAction")
	public String NewAction(Model model) {
		//session.setAttribute("dddd", "dfdf");
		List<Quartier> quartiers=quartier.getAll();
		model.addAttribute("quartiers", quartiers);
		
		List<Projet> projets=projet.getAll();
		model.addAttribute("projets", projets);
		List<Situation> situations=situationrepo.findAll();
		model.addAttribute("situations", situations);
		List<Typeaction> typesAct=typeaction.getAll();
		model.addAttribute("typesAct", typesAct);
	
	    
		return "PageAddAction";
	}
	
	@RequestMapping("/PageAddActOrg")
	public String AddActOrg(Model model,@RequestParam("idAction") String idAction,@RequestParam("idOrga") String idOrga)
	{  
		try {
			
			Action action=actionMetierImp.find(Integer.parseInt(idAction)).get();
			Organisateur organisateur=organisateurRepo.findById(Integer.parseInt(idOrga)).get();
			System.out.println("IdAction : "+idAction+"   IdOrga : "+idOrga);
			/*if(!action.equals(null) && !organisateur.equals(null))
			{}*/
			 organisateur.getActions().add(action);
			action.getOrganisateurs().add(organisateur);
			 
			/*Organisateur organisateur=new 	Organisateur();
			  organisateur.setNom("Directeur");
			  organisateur.setDescription("Superviseur");
			  organisateurRepo.save(organisateur);
			  nvAction.getOrganisateurs().add(organisateur);
			  organisateur.getActions().add(nvAction);*/
		
		//model.addAttribute("actions", actions);
		}catch(Exception e) {}
		return "ActionOrganisateur";
	}
	
	
	
	@RequestMapping("/PageactOrga")
	public String ActionOrga(Model model)
	{  
		try {
		List<Action> actions=actionMetierImp.getAll();
		List<Organisateur> organisteurs=organisateurRepo.findAll();
		model.addAttribute("actions", actions);
		model.addAttribute("organisteurs", organisteurs);
		}catch(Exception e) {}
		return "ActionOrganisateur";
	}
	
	
	@RequestMapping("/addAction")
	public String AddAction(Model model,String ASituation,String dateDebut,String inputNom,String iputObjectif,@RequestParam("seletQuartier") String seletQuartier,
	@RequestParam("seletTypeAction") String seletTypeAction,@RequestParam("seletProjet") String seletProjet,int inputImpact,double inputBudget) 
	{   int i=0;
		/*List<Action> actions=actionMetierImp.getAll();
		model.addAttribute("actions", actions);
		List<Quartier> quartiers=quartier.getAll();
		model.addAttribute("quartiers", quartiers);
		//double budget=inputBudget;
	
		List<Projet> projets=projet.getAll();
		model.addAttribute("projets", projets);*/
	Situation situation=situationrepo.findById(Integer.parseInt(ASituation)).get();
		System.out.println("Date value ****"+dateDebut);
		Action act=new Action();
//		if(inputNom.matches("[a-zA-Z]+")==true )
			if(inputNom.matches("[a-zA-Z.\\s]+")==true )
		{System.out.println("Nom action ::"+inputNom);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	         Date dateSys = new Date();
	         String frmtDate = dateFormat.format(dateSys);
				act.setNom(inputNom);
				System.out.println("Date System ::"+frmtDate);
				act.setDateCreation(frmtDate);
				act.setObjectif(iputObjectif);
				act.setSituation(situation);
				act.setDateRealisation(dateDebut);
			//Organisme orga=proj.get().getOrganisme();
				System.out.println("VAAAAAAL"+111);
			
			
			
		}
		else {
			model.addAttribute("MsgNom", "Name input invalide");
			i=i+1;
		}
		
		if(!seletQuartier.equals("")) 
		{Optional<Quartier> quar=quartier.find(Integer.parseInt(seletQuartier));
			act.setQuartier(quar.get());
			
		}
		else {
			model.addAttribute("MsgQuartier", "Select Quartier");
			i=i+1;
			System.out.println("VAAAAAAL"+2222);
		}
		
		if(!seletProjet.equals("")) 
		{
			Optional<Projet> proj=projet.find(Integer.parseInt(seletProjet));
			System.out.println("VAAAAAAL"+3333);

			
			
			act.setProjet(proj.get());
			
		}
		else {
			model.addAttribute("MsgProjet", "Select Project");
			i=i+1;
		}
		if(!seletTypeAction.equals("")) 
		{
			Optional<Typeaction> typeact=typeaction.find(Integer.parseInt(seletTypeAction));
			act.setTypeaction(typeact.get());
			System.out.println("VAAAAAAL"+4444);

			
		}
		else {
			model.addAttribute("MsgTypeAct", "Select TypeAction");
			i=i+1;	
		}
		if(i==0)
		{			System.out.println("VAAAAAAL"+151515151);

			Optional<Contact> cnt=contact.findById(1);
		System.out.println("VAAAAAAL"+55555);

		
		
			
			
			act.setContact(cnt.get());
			
			act.setImpact(inputImpact);
			act.setBudget(inputBudget);
			System.out.println("VAAAAAAL"+66666);

			actionMetierImp.add(act);
			
			
			return "redirect:/first";
		}
		else {return "redirect:/NewAction";}
		
	}
	
	@RequestMapping("/ActUpdate")
	public String UpdateAction(Model model,String dateDebut,String UNom,String UObjectif,@RequestParam("UQuartier") String UQuartier,
			String ASituation,@RequestParam("UProjet") String UProjet,@RequestParam("UpdateId") String UpdateId,int UImpact,double UBudget)
	{
		Action action=new Action();
		String id="";
		try {
			
			System.out.println("ID  :"+UpdateId + "  UQaurtier  :"+UQuartier + "  Uprojet" + UProjet );
		/*List<Quartier> quartiers=quartier.getAll();
		model.addAttribute("quartiers", quartiers);
		//double budget=inputBudget;
		
		List<Projet> projets=projet.getAll();
		model.addAttribute("projets", projets);*/
		Optional<Action> oldAction=actionMetierImp.find(Integer.parseInt(UpdateId));
		Situation situation=situationrepo.findById(Integer.parseInt(ASituation)).get();
		Action nvAction=oldAction.get();
		/*Organisateur organisateur=new 	Organisateur();
		  organisateur.setNom("Directeur");
		  organisateur.setDescription("Superviseur");
		  organisateurRepo.save(organisateur);
		  nvAction.getOrganisateurs().add(organisateur);
		  organisateur.getActions().add(nvAction);*/
		Optional<Quartier> quar=quartier.find(Integer.parseInt(UQuartier));
		Optional<Projet> proj=projet.find(Integer.parseInt(UProjet));
		Optional<Typeaction> typeact=typeaction.find(1);
		//Organisme orga=proj.get().getOrganisme();
		
		Optional<Contact> cnt=contact.findById(2);
		 id=String.valueOf(nvAction.getIdAction());
		
		action.setIdAction(oldAction.get().getIdAction());
		nvAction.setNom(UNom);
		nvAction.setObjectif(UObjectif);
		nvAction.setQuartier(quar.get());
		nvAction.setProjet(proj.get());
		nvAction.setContact(cnt.get());
		nvAction.setSituation(situation);
		nvAction.setImpact(UImpact);
		nvAction.setBudget(UBudget);
		nvAction.setTypeaction(typeact.get());
		nvAction.setDateRealisation(dateDebut);
		actionMetierImp.edit(nvAction);
		
	  
	  
		}catch(Exception e) {
			System.out.println("EXception !!!!!!!"+e.toString());
		}
		
		return "redirect:first";
	}
	
	
//	@RequestMapping("/EditeAction")
	@RequestMapping(value = "/EditeAction", method = { RequestMethod.GET, RequestMethod.POST })
	public String EditeAction(Model model,@RequestParam("updateA") String updateA) {
		/*,@RequestParam("updateA") String updateA*/
		
		List<Quartier> quartiers=quartier.getAll();
		model.addAttribute("quartiers", quartiers);
		
		List<Projet> projets=projet.getAll();
		model.addAttribute("projets", projets);
		
		List<Typeaction> typesAct=typeaction.getAll();
		model.addAttribute("typesAct", typesAct);
		
		Optional<Action> action=actionMetierImp.find(Integer.parseInt(updateA));
		Quartier quar=action.get().getQuartier();
		//String aa=action.get().getQuartier().getNom();
		model.addAttribute("actionE", action.get());
		List<Situation> situations=situationrepo.findAll();
		model.addAttribute("situations", situations);
		
		
	
		return "PageEdite";
	}
	
	
	@RequestMapping("/PageRessUpdate")
	public String PageRessUpdate(Model model,@RequestParam("RessId") String RessId) {
		/*,@RequestParam("updateA") String updateA*/
		
		
		Optional<Ressource> ressource=ressourceMetierImp.find(Integer.parseInt(RessId));
		System.out.print("Ressource Id : "+ressource.get().getIdRessource());
		model.addAttribute("ressource", ressource.get());
		
		//<Action> action=actionMetierImp.find(ressource.get().getAction().getIdAction());
		List<Action> actions=actionMetierImp.getAll();
		System.out.print("action nom : "+actions.get(0).getNom());
		//String aa=action.get().getQuartier().getNom();
		model.addAttribute("actions", actions);
		
		//String aa=action.get().getQuartier().getNom();
		
		
		
	
	
		return "EditeRessource";
	}
	
	@RequestMapping("/UpdateRess")
	public String UpdateRess(Model model,String RessId,double montant,@RequestParam("idAction")String idAction,String description,RedirectAttributes redirectattribute) {
		/*,@RequestParam("updateA") String updateA*/
		
		
	Ressource ressource=ressourceMetierImp.find(Integer.parseInt(RessId)).get();
	Action action=actionMetierImp.find(Integer.parseInt(idAction)).get();
		ressource.setMontant(montant);
		ressource.setAction(action);
		ressource.setDescription(description);
		ressourceMetierImp.edit(ressource);
		System.out.print("Ressource Id : "+ressource.getIdRessource());
		redirectattribute.addFlashAttribute("RessId",RessId);
		//model.addAttribute("ressource", ressource);
		
		//<Action> action=actionMetierImp.find(ressource.get().getAction().getIdAction());
		/*List<Action> actions=actionMetierImp.getAll();
		System.out.print("action nom : "+actions.get(0).getNom());
		//String aa=action.get().getQuartier().getNom();
		model.addAttribute("actions", actions);*/
		
		//String aa=action.get().getQuartier().getNom();
		
		
		
	
		return  "redirect:ress";
	}
	
	
	
	
	@RequestMapping("/deleteA")
	public String DeleteAction(Model model,@RequestParam("DeleteA") String DeleteA,RedirectAttributes redirectattribute)
	{  
		try {
		Optional<Action> action=actionMetierImp.find(Integer.parseInt(DeleteA));
		//redirectattribute.addFlashAttribute("message","media deleted successfully");
		actionMetierImp.delete(action.get());
		System.out.println("media deleted successfully");
		mediarepo.deleteMediaByActId(Integer.parseInt(DeleteA));
		ressourcerepo.deleteRessourceByActId(Integer.parseInt(DeleteA));
		}catch(Exception e){ System.out.println("Delete Error XXXXXXXXX :"+e);}
		return "redirect:first";
	}
	
	
	
	@RequestMapping("/nav")
	public String Datapag(Model model) {
		
		List<Action> actions=actionMetierImp.getAll();
		model.addAttribute("actions", actions);
		
		
	/*	
	 * @RequestParam("seletQuartier") String seletQuartier,@RequestParam("seletTypeAction") String seletTypeAction
	 * System.out.println("Le quartier selectionner est :"+seletTypeAction);
		System.out.println("Le Type d'action selectionner est :"+seletQuartier);
		Optional<Quartier> quar=quartier.find(Integer.parseInt(seletQuartier));
		System.out.println("Le Nom de quartier  :"+quar.get().getNom());*/
		return "dataPage";
	}
	
	
	
	@RequestMapping("/Media")
	  public String UploadPage(Model model) {
		List<Action> actions=actionMetierImp.getAll();
		model.addAttribute("actions", actions);
		
		List<Typemedia> mediatypes=typemediarepo.findAll();
		model.addAttribute("mediatypes", mediatypes);
		  return "uploadview";
		  
	  }
	
	@RequestMapping("/ListMedia")
	  public String MediaList(Model model) {
		List<Action> actions=actionMetierImp.getAll();
		List<Media> medias=mediarepo.findAll();
		model.addAttribute("actions", actions);
		model.addAttribute("medias", medias);
		
		model.addAttribute("imageDir", imageDir);
//		Map md = model.asMap();
//	    for (Object modelKey : md.keySet()) {
//	        Object modelValue = md.get(modelKey);
//	        
////	        model.addAttribute(String.valueOf(modelKey),String.valueOf(modelValue));
//	        //model.addAttribute("a","a");
//	        System.out.println(modelKey + " -- " + modelValue);
//	    }
//		
		  return "MediaAction";
		  
	  }
	
	@RequestMapping("/EditeMedia")
	  public String MediaUpdate(Model model ,@RequestParam("IdMedia")String IdMedia) {
		List<Action> actions=actionMetierImp.getAll();
		//List<Media> medias=mediarepo.findAll();
		//model.addAttribute("medias", medias);
		model.addAttribute("actions", actions);
		Media media=mediarepo.findById(Integer.parseInt(IdMedia)).get();
		model.addAttribute("media", media);
		List<Typemedia> mediatypes=typemediarepo.findAll();
		model.addAttribute("mediatypes", mediatypes);
		
		
		
		
		  return "UpdateMedia";
		  
	  }
	
	@RequestMapping("/DeleteMedia")
	  public String DeleteMedia(Model model,@RequestParam("MediaId")String MediaId,RedirectAttributes redirectattribute) {
		
		Media media=mediarepo.findById(Integer.parseInt(MediaId)).get();
		
		if(media!=null) 
		{
			mediarepo.delete(media);
			//model.addAttribute("message", "media deleted successfully");
			redirectattribute.addFlashAttribute("message","media deleted successfully");
			
		}
		else 
		{
			//model.addAttribute("message", "Oops media dosen't deleted!!");
			redirectattribute.addFlashAttribute("message","Oops media dosen't deleted!!");
		}
		/*List<Action> actions=actionMetierImp.getAll();
		List<Media> medias=mediarepo.findAll();
		model.addAttribute("actions", actions);
		model.addAttribute("medias", medias);*/
		
		
//	rd.addFlashAttribute("ModelMsg","*******model message parsed *****");
//		  return MediaList(model) ;
		return "redirect:ListMedia" ;
		  
	  }
	
	@RequestMapping("/upload")
	  public String upload(Model model,@RequestParam("idTypeM")String idTypeM,@RequestParam("file") MultipartFile file,
			  String NomMedia,String note,@RequestParam("idAction")String idAction,RedirectAttributes redirectattribute) {
//		  StringBuilder fileNames = new StringBuilder();
//		  for (MultipartFile file : files) {
//			  
//			  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
//			 
//			  fileNames.append(file.getOriginalFilename()+" ");
//			  System.out.println("File Name : nnnnnnn"+fileNames);
//			  System.out.println("File Path : nnnnnnn"+fileNameAndPath);
		Media media=new Media();
			  try {
				  Optional<Action> action=actionMetierImp.find(Integer.parseInt(idAction));
				  Typemedia type=typemediarepo.findById(Integer.parseInt(idTypeM)).get();
				  media.setNom(NomMedia);
				  media.setNote(note);
				  media.setTypemedia(type);
				  
				  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			         Date dateSys = new Date();
			         String frmtDate = dateFormat.format(dateSys);
			         media.setDateAjout(frmtDate);
				  
				//Files.write(fileNameAndPath, file.getBytes());
				  if(!file.isEmpty())
				  {
					  System.out.println("File Name :"+file.getOriginalFilename());
					  file.transferTo(new File(imageDir+file.getOriginalFilename()));
					  media.setFichier(file.getOriginalFilename());
					  if(action != null) {
						  media.setAction(action.get());
						  Media NewMedia=mediarepo.save(media);
					  if( NewMedia!= null)
					  {
//						  model.addAttribute("msgS", "Successfully uploaded file, Media "+media.getNom()+" insered ");
						  redirectattribute.addFlashAttribute("msgS","Successfully uploaded file, Media "+media.getNom()+" insered ");
					  }
					  else { //model.addAttribute("msgW", "Media dosen't insered retry again");
					  redirectattribute.addFlashAttribute("msgW","Media dosen't insered retry again");
					  }
					 
					  }
					  else { //model.addAttribute("msgW", "Media dosen't insered Check your data !!");
					  redirectattribute.addFlashAttribute("msgW","Media dosen't insered Check your data !!");
					  }
				  }
				  else { //model.addAttribute("msgW", "File dosen't found !!");
				  redirectattribute.addFlashAttribute("msgW","File dosen't found !!");
				  }
			} catch (Exception e) {
				e.printStackTrace();
				//model.addAttribute("msgE", "Error while uploading file");
				redirectattribute.addFlashAttribute("msgE","Error while uploading file");
				
			}
//	 }
		  //model.addAttribute("msg", "Successfully uploaded files ");
		  return "redirect:ListMedia";
	  }
	
	
	
	@RequestMapping("/UpdateModiaData")
	  public String MediaUpdateById(Model model,@RequestParam("idTypeM")String idTypeM,@RequestParam("IdMedia") String IdMedia,@RequestParam("file") MultipartFile file,
			  String NomMedia,String note,@RequestParam("idAction")String idAction,RedirectAttributes redirectattribute) {
//		  StringBuilder fileNames = new StringBuilder();
//		  for (MultipartFile file : files) {
//			  
//			  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
//			 
//			  fileNames.append(file.getOriginalFilename()+" ");
//			  System.out.println("File Name : nnnnnnn"+fileNames);
//			  System.out.println("File Path : nnnnnnn"+fileNameAndPath);
	
			  try {
				  Optional<Action> action=actionMetierImp.find(Integer.parseInt(idAction));
					Media media=mediarepo.findById(Integer.parseInt(IdMedia)).get();
					 Typemedia type=typemediarepo.findById(Integer.parseInt(idTypeM)).get();
				  media.setNom(NomMedia);
				  media.setNote(note);
				  media.setTypemedia(type);
//				  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			         Date dateSys = new Date();
//			         String frmtDate = dateFormat.format(dateSys);
//			         media.setDateAjout(frmtDate);
				  
				//Files.write(fileNameAndPath, file.getBytes());
				  if(!file.isEmpty())
				  {
					  System.out.println("File Name :"+file.getOriginalFilename());
					  file.transferTo(new File(imageDir+file.getOriginalFilename()));
					  media.setFichier(file.getOriginalFilename());
					  
				  }
				  
				  else { //model.addAttribute("msgW", "File dosen't found !!");
					  if(media.getFichier().equals("")) 
					  {
						  redirectattribute.addFlashAttribute("msgW","File dosen't found !!");
					  }
					  else {System.out.println("XXxx   :::::"+media.getFichier());}
				 
				  }
				  if(action != null) {
					  media.setAction(action.get());
					  Media NewMedia=mediarepo.save(media);
				  if( NewMedia!= null)
				  {
					  //model.addAttribute("msgS", "Successfully ,Media "+media.getNom()+" Updated ");
					  redirectattribute.addFlashAttribute("msgS","Successfully ,Media "+media.getNom()+" Updated");
				  }
				  else { //model.addAttribute("msgW", "Media dosen't insered retry again");
				  redirectattribute.addFlashAttribute("msgW","Media dosen't insered retry again");
				  }
				 
				  }
				  else { //model.addAttribute("msgW", "Media dosen't insered Check your data !!");
				  redirectattribute.addFlashAttribute("msgW","Media dosen't insered Check your data !!");
				  }
			} catch (Exception e) {
				e.printStackTrace();
				//model.addAttribute("msgE", "Error while uploading file");
				redirectattribute.addFlashAttribute("msgE","Error while uploading file");
				
			}
//	 }
		  //model.addAttribute("msg", "Successfully uploaded files ");
		  return "redirect:ListMedia";
	  }
	
	
	/*@RequestMapping("/uptest")
	  public String upload(Model model,@RequestParam("files") MultipartFile file) {
		 //String  fileNames=files.getName();
		 String a="";
		 try {
	            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
	            
	        } catch (Exception e) {
	        	System.out.println("Exception : EEEEEEEEE"+e.toString());
	          throw new RuntimeException("FAIL! -> message = " + e.getMessage());
	         
	         
	        }
		 //
		  try {
			  String fileNameAndPath=files.getAbsolutePath();
			  String Path=files.getPath();
			
			 
			 
			
			 System.out.println("File Name : nnnnnnn"+fileNames);
			  System.out.println("File Absolutepath : nnnnnnn"+fileNameAndPath);
			  System.out.println("File Path : nnnnnnn"+Path);
			 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		  
		  model.addAttribute("msg", "Successfully uploaded files ");
		  return "uploadstatusview";
	  }*/
	
	/*@RequestMapping("/second")
	public String search(Model model,String code) {
		String val="default";
		Personne p1=new Personne();
		p1.setId(1);
		p1.setNom("ali");
		p1.setPrenom("ahmed");
		p1.setAdresses(null);
		Personne p2=new Personne();
		p2.setId(2);
		p2.setNom("youssef");
		p2.setPrenom("aissa");
		p2.setAdresses(null);
		Personne p3=new Personne();
		p3.setId(3);
		p3.setNom("kamal");
		p3.setPrenom("zahri");
		p3.setAdresses(null);
		
		maListe.add(p1);
		maListe.add(p2);
		maListe.add(p3);
		//model.addAttribute("personne", maListe.get(2));


		//System.out.println("XXXXXXXXX"+code);
		//int nbr=Integer.parseInt(code)-1;
		//model.addAttribute("personne", maListe.get(nbr));
		 for(int i = 0 ; i < maListe.size(); i++){
		 	//String maValeur = String.valueOf(maListe.get(i).getId());
			 String donnee=maListe.get(i).getNom();
			 //System.out.println("LLLLL"+donnee);
		 	if(code.equals(donnee)) 
		 	{ //System.out.println("hhhhhhhh"+maListe.get(i).getPrenom());
		 		model.addAttribute("personne", maListe.get(i));
		 	}
		 
		 }
	
		
		return "page";
	}
*/
	
	public  boolean validateJavaDate(String strDate)
	   {
		/* Check if date is 'null' */
		if (strDate.trim().equals(""))
		{
		    return false;
		}
		/* Date is not 'null' */
		else
		{
		    /*
		     * Set preferred date format,
		     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy/mm/dd");
		    sdfrmt.setLenient(false);
		    /* Create Date object
		     * parse the string into date 
	             */
		    try
		    {
		        Date javaDate = sdfrmt.parse(strDate); 
		        System.out.println(strDate+" is valid date format");
		       
		    }
		    /* Date format is invalid */
		    catch (ParseException e)
		    {
		        System.out.println(strDate+" is Invalid Date format");
		        return false;
		    }
		    /* Return true if date format is valid */
		    return true;
		}
	   }
	
}
