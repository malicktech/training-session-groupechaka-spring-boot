package com.chaka.jhipster.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.chaka.jhipster.domain.Operation;
import com.chaka.jhipster.security.SecurityUtils;
import com.chaka.jhipster.service.BalanceService;
import com.chaka.jhipster.service.OperationService;
import com.chaka.jhipster.web.rest.errors.BadRequestAlertException;
import com.chaka.jhipster.web.rest.errors.InternalServerErrorException;
import com.chaka.jhipster.web.rest.util.HeaderUtil;
import com.chaka.jhipster.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Operation.
 */
@RestController
@RequestMapping("/api")
public class OperationResource {

    private final Logger log = LoggerFactory.getLogger(OperationResource.class);

    private static final String ENTITY_NAME = "operation";

    private final OperationService operationService;

    private final BalanceService balanceService;
    
    public OperationResource(OperationService operationService, BalanceService balanceService) {
        this.operationService = operationService;
        this.balanceService = balanceService;
    }

    /**
     * POST  /operations : Create a new operation.
     *
     * @param operation the operation to create
     * @return the ResponseEntity with status 201 (Created) and with body the new operation, or with status 400 (Bad Request) if the operation has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/operations")
    @Timed
    public ResponseEntity<Operation> createOperation(@Valid @RequestBody Operation operation) throws URISyntaxException {
        log.debug("REST request to save Operation : {}", operation);
        if (operation.getId() != null) {
            throw new BadRequestAlertException("A new operation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Operation result = balanceService.add(operation);
        return ResponseEntity.created(new URI("/api/operations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /operations : Updates an existing operation.
     *
     * @param operation the operation to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated operation,
     * or with status 400 (Bad Request) if the operation is not valid,
     * or with status 500 (Internal Server Error) if the operation couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/operations")
    @Timed
    public ResponseEntity<Operation> updateOperation(@Valid @RequestBody Operation operation) throws URISyntaxException {
        log.debug("REST request to update Operation : {}", operation);
        if (operation.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Operation result = operationService.save(operation);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, operation.getId().toString()))
            .body(result);
    }

    /**
     * GET  /operations : get all the operations.
     *
     * @param pageable the pagination information
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many)
     * @return the ResponseEntity with status 200 (OK) and the list of operations in body
     */
    @GetMapping("/operations")
    @Timed
    public ResponseEntity<List<Operation>> getAllOperations(Pageable pageable, @RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get a page of Operations");
        Page<Operation> page;
        final String userLogin = SecurityUtils.getCurrentUserLogin().orElseThrow(() -> new InternalServerErrorException("Current user login not found"));
        if (eagerload) {
            page = operationService.findAllWithEagerRelationships(pageable);
        } else {
            page = operationService.findByBankAccountUserLoginOrderByDateDesc(userLogin ,pageable);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, String.format("/api/operations?eagerload=%b", eagerload));
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /operations/:id : get the "id" operation.
     *
     * @param id the id of the operation to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the operation, or with status 404 (Not Found)
     */
    @GetMapping("/operations/{id}")
    @Timed
    public ResponseEntity<Operation> getOperation(@PathVariable Long id) {
        log.debug("REST request to get Operation : {}", id);
        Optional<Operation> operation = operationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(operation);
    }

    /**
     * DELETE  /operations/:id : delete the "id" operation.
     *
     * @param id the id of the operation to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/operations/{id}")
    @Timed
    public ResponseEntity<Void> deleteOperation(@PathVariable Long id) {
        log.debug("REST request to delete Operation : {}", id);
        operationService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
