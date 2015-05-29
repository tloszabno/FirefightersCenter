package pl.edu.agh.integracja.firefighterspost.gui.model;

import java.util.ArrayList;
import java.util.List;

public class ReportGuiModel {

  private String notificationId;
  private String postName;
  private String acttionName;
  private String accidentType;
  private String community;
  private String areaSize;
  private String objectName;
  private String owner;
  private String creator;

  private List<ReportDamageGuiModel> damages = new ArrayList<>();
  private List<ReportEquipmentGuiModel> usedEquipment = new ArrayList<>();
  private List<ReportFirefighterGuiModel> firefighters = new ArrayList<>();
  private List<ReportBrigadeGuiModel> brigades = new ArrayList<>();

  public String getNotificationId() {
    return notificationId;
  }

  public ReportGuiModel setNotificationId(String notificationId) {
    this.notificationId = notificationId;
    return this;
  }

  public String getPostName() {
    return postName;
  }

  public ReportGuiModel setPostName(String postName) {
    this.postName = postName;
    return this;
  }

  public String getActtionName() {
    return acttionName;
  }

  public ReportGuiModel setActtionName(String acttionName) {
    this.acttionName = acttionName;
    return this;
  }

  public String getAccidentType() {
    return accidentType;
  }

  public ReportGuiModel setAccidentType(String accidentType) {
    this.accidentType = accidentType;
    return this;
  }

  public String getCommunity() {
    return community;
  }

  public ReportGuiModel setCommunity(String community) {
    this.community = community;
    return this;
  }

  public String getAreaSize() {
    return areaSize;
  }

  public ReportGuiModel setAreaSize(String areaSize) {
    this.areaSize = areaSize;
    return this;
  }

  public String getObjectName() {
    return objectName;
  }

  public ReportGuiModel setObjectName(String objectName) {
    this.objectName = objectName;
    return this;
  }

  public String getOwner() {
    return owner;
  }

  public ReportGuiModel setOwner(String owner) {
    this.owner = owner;
    return this;
  }

  public String getCreator() {
    return creator;
  }

  public ReportGuiModel setCreator(String creator) {
    this.creator = creator;
    return this;
  }

  public List<ReportDamageGuiModel> getDamages() {
    return damages;
  }

  public ReportGuiModel setDamages(List<ReportDamageGuiModel> damages) {
    this.damages = damages;
    return this;
  }

  public List<ReportEquipmentGuiModel> getUsedEquipment() {
    return usedEquipment;
  }

  public ReportGuiModel setUsedEquipment(List<ReportEquipmentGuiModel> usedEquipment) {
    this.usedEquipment = usedEquipment;
    return this;
  }

  public List<ReportFirefighterGuiModel> getFirefighters() {
    return firefighters;
  }

  public ReportGuiModel setFirefighters(List<ReportFirefighterGuiModel> firefighters) {
    this.firefighters = firefighters;
    return this;
  }

  public List<ReportBrigadeGuiModel> getBrigades() {
    return brigades;
  }

  public ReportGuiModel setBrigades(List<ReportBrigadeGuiModel> brigades) {
    this.brigades = brigades;
    return this;
  }
}
